# 🚚 Exercise: "NightPort" — A Harbor Cargo System

You are building the software for a small night harbor. Trucks arrive, robot cranes
load/unload containers, and a control tower watches everything at once.

Everything runs **at the same time** (threads), and several threads touch the **same
harbor data**, so you must protect it (synchronization).

Write it in **Java**. One file per class. Package: `nightport`.

---

## Part 0 — What you must deliver

| Type | Count | Names |
|---|---|---|
| Abstract parent class | 1 | `HarborUnit` |
| Child classes | 5 | `Truck`, `Crane`, `Forklift`, `Ship`, `ControlTower` |
| Interfaces | 3 | `Loadable`, `Trackable`, `Maintainable` |
| Custom exceptions | 4 | `HarborException`, `OverloadException`, `UnitOfflineException`, `SlotUnavailableException` |
| Shared resource class | 1 | `Dock` |
| Runner | 1 | `Main` |

---

## Part 1 — The exceptions

### `HarborException extends Exception`
- **Checked** exception. Base for all others.
- Fields: `private final String unitId;`
- Constructors: `HarborException(String message, String unitId)` and
  `HarborException(String message, String unitId, Throwable cause)`
- Method: `public String getUnitId()`
- Override `getMessage()` so it returns `"[" + unitId + "] " + super.getMessage()`

### `OverloadException extends HarborException`
- Thrown when you put more weight on a unit than its capacity.
- Extra fields: `private final double attemptedWeight; private final double capacity;`
- Constructor: `(String unitId, double attemptedWeight, double capacity)` — build the
  message yourself inside, e.g. `"Tried 900.0kg but capacity is 500.0kg"`.
- Getters for both extra fields.

### `UnitOfflineException extends HarborException`
- Thrown when someone calls a method on a unit whose `status` is `OFFLINE` or `BROKEN`.
- Constructor: `(String unitId, UnitStatus currentStatus)`

### `SlotUnavailableException extends HarborException`
- Thrown when a unit asks the `Dock` for a slot and none is free within the timeout.
- Constructor: `(String unitId, int totalSlots)`

> Also create `enum UnitStatus { IDLE, WORKING, OFFLINE, BROKEN }`
> and `enum CargoType { GENERAL, FRAGILE, HAZARDOUS, REFRIGERATED }`

---

## Part 2 — The interfaces

### `interface Trackable`
Anything that the control tower can watch.
```
String getId();
String getLocation();
long getLastPingMillis();
default boolean isStale() { ... }   // true if last ping older than 5000 ms
```

### `interface Loadable`
Anything that can hold cargo.
```
void load(Container c) throws OverloadException, UnitOfflineException;
Container unload() throws UnitOfflineException;   // returns null if empty
double getCurrentWeight();
double getCapacity();
default double getFreeSpace() { return getCapacity() - getCurrentWeight(); }
```

### `interface Maintainable`
Anything that can break and be repaired.
```
void reportFault(String reason);
void repair() throws UnitOfflineException;
int getFaultCount();
static boolean needsUrgentService(Maintainable m) { return m.getFaultCount() >= 3; }
```

---

## Part 3 — The parent class

### `abstract class HarborUnit implements Trackable`
Fields (all `protected` unless said otherwise):
- `private final String id;`
- `private String location;`
- `private volatile UnitStatus status;`
- `private volatile long lastPingMillis;`
- `protected final Object lock = new Object();`  ← your own monitor object

Constructor: `HarborUnit(String id, String location)` → status starts `IDLE`,
ping = `System.currentTimeMillis()`.

Concrete methods:
- `getId()`, `getLocation()`, `getLastPingMillis()` (from `Trackable`)
- `synchronized void setLocation(String loc)`
- `UnitStatus getStatus()` / `void setStatus(UnitStatus s)`
- `void ping()` → updates `lastPingMillis`
- `protected void requireOnline() throws UnitOfflineException` → throws if status is
  `OFFLINE` or `BROKEN`. **Every action method in children must call this first.**
- `@Override public String toString()`

Abstract methods children MUST implement:
- `public abstract void performShift() throws HarborException;`  ← the unit's main job
- `public abstract String getUnitKind();`

---

## Part 4 — The five children

### 1. `class Truck extends HarborUnit implements Loadable, Runnable`
- Fields: `private final double capacity; private final List<Container> cargo = new ArrayList<>(); private final Dock dock; private volatile boolean running = true;`
- `load(Container c)`: `synchronized (lock)` → call `requireOnline()`, then if
  `getCurrentWeight() + c.getWeight() > capacity` throw `OverloadException`. Else add.
- `unload()`: `synchronized (lock)` → remove and return last container, or `null`.
- `getCurrentWeight()`: `synchronized (lock)` → sum of container weights.
- `performShift()`: ask `dock.acquireSlot(this)`, sleep a random 200–600 ms to simulate
  driving, then `dock.releaseSlot(this)` in a **`finally`** block.
- `run()`: loop while `running`, call `performShift()`, catch `HarborException` and print
  it, catch `InterruptedException` → `Thread.currentThread().interrupt(); break;`
- `stop()` method sets `running = false`.

### 2. `class Crane extends HarborUnit implements Loadable, Maintainable, Runnable`
- Fields: `private final double capacity; private Container held; private int faultCount; private final Dock dock;`
- Holds **only one** container at a time. If `load()` is called while `held != null`,
  throw `OverloadException`.
- `reportFault(String reason)`: increment `faultCount`, set status `BROKEN`.
- `repair()`: `requireOnline()` will throw here on purpose — so instead write your own
  check: if status is `OFFLINE` throw `UnitOfflineException`, if `BROKEN` reset to `IDLE`.
- `performShift()`: takes a container from `dock.takeContainer()` (this **blocks** using
  `wait()`), loads it, sleeps, then `dock.storeContainer(...)`.
- Randomly (10% chance) call `reportFault("cable slip")` to make exceptions fire.

### 3. `class Forklift extends HarborUnit implements Loadable, Maintainable`
- Smaller capacity. Only accepts `CargoType.GENERAL` and `FRAGILE`.
- If given `HAZARDOUS` or `REFRIGERATED`, throw a `HarborException` with a clear message.
- `performShift()`: moves containers between two dock zones.

### 4. `class Ship extends HarborUnit implements Loadable, Trackable`
- Fields: `private final int maxContainers; private final Deque<Container> hold = new ArrayDeque<>();`
- Unloading is **LIFO** (last in, first out) — use the `Deque`.
- `performShift()`: unloads everything into the dock, one container at a time, with a
  `synchronized` block around the whole batch so no one interleaves.
- Override `isStale()` from `Trackable` — a ship at sea is allowed 30000 ms instead of 5000.

### 5. `class ControlTower extends HarborUnit implements Runnable`
- Fields: `private final List<Trackable> watched = new CopyOnWriteArrayList<>();`
- `void watch(Trackable t)` / `void unwatch(Trackable t)`
- `run()`: every 1000 ms print a status table of every watched unit and flag stale ones.
  Loop until interrupted.
- `performShift()`: prints a one-time full report.
- It holds **no cargo** — this is why `Loadable` is an interface and not in the parent. 💡

---

## Part 5 — The shared resource (this is the thread part)

### `class Dock`
- Fields:
  - `private final int totalSlots;`
  - `private int freeSlots;`
  - `private final Queue<Container> yard = new LinkedList<>();`
  - `private final int yardCapacity;`
  - `private final Object slotLock = new Object();`
  - `private final Object yardLock = new Object();`

Methods — **all must be thread-safe**:

| Method | Rule |
|---|---|
| `void acquireSlot(HarborUnit u) throws SlotUnavailableException, InterruptedException` | inside `synchronized (slotLock)`: `while (freeSlots == 0) slotLock.wait(3000);` if still 0 after the wait → throw `SlotUnavailableException`. Else `freeSlots--`. |
| `void releaseSlot(HarborUnit u)` | `synchronized (slotLock)`: `freeSlots++; slotLock.notifyAll();` |
| `void storeContainer(Container c) throws InterruptedException` | `synchronized (yardLock)`: `while (yard.size() == yardCapacity) yardLock.wait();` add, then `notifyAll()`. |
| `Container takeContainer() throws InterruptedException` | `synchronized (yardLock)`: `while (yard.isEmpty()) yardLock.wait();` poll, then `notifyAll()`. |
| `int getFreeSlots()` | synchronized read |

⚠️ Rules you must follow:
1. Always use `while`, never `if`, around `wait()`.
2. Never call `wait()` / `notifyAll()` outside a `synchronized` block on that same object.
3. Never hold `slotLock` and `yardLock` at the same time → that's how deadlocks are born.

### `class Container`
Simple value class: `id` (String), `weight` (double), `type` (CargoType).
Make the fields `final`, add getters, `equals`, `hashCode`, `toString`. No setters.

---

## Part 6 — `Main`

1. Create a `Dock` with **3 slots** and a yard capacity of **10**.
2. Create 4 `Truck`s, 2 `Crane`s, 1 `Forklift`, 1 `Ship`, 1 `ControlTower`.
3. Register every unit with the tower via `watch(...)`.
4. Pre-fill the ship with 12 containers of mixed `CargoType`.
5. Start each `Runnable` in its own `Thread`. Name the threads (`"truck-1"` etc.).
6. Let it run 10 seconds, then stop the trucks, `interrupt()` the tower, and `join()` all
   threads.
7. Wrap the whole body in try/catch and print a final summary:
   total containers moved, total faults, which units need urgent service
   (use `Maintainable.needsUrgentService`).

---

## Part 7 — Proof you got it right ✅

Your program must visibly produce, in the console:
- At least one `SlotUnavailableException` (4 trucks, only 3 slots → guaranteed).
- At least one `OverloadException`.
- At least one `UnitOfflineException` (break a crane, then try to load it).
- At least one rejected hazardous container at the forklift.
- A crane **blocking** on an empty yard and waking up when a truck delivers.
- A clean shutdown: no thread left alive, no `InterruptedException` stack trace dumped.

---

## Part 8 — Bonus rounds (do these if the above felt easy)

1. **Swap the hand-written locks** for `ReentrantLock` + `Condition`, then for a
   `Semaphore` (slots) + `BlockingQueue` (yard). Compare how much code disappears.
2. **Break it on purpose**: change one `while (…) wait()` into `if (…) wait()` and run it
   200 times until you catch the spurious-wakeup bug. Now you'll never forget the rule.
3. **Force a deadlock**: make `Truck` lock `slotLock` then `yardLock`, and `Crane` lock
   them in the reverse order. Watch it freeze. Then fix it with lock ordering.
4. Add a `Stream`-based report in `ControlTower`: group units by `UnitStatus`, sort by
   fault count.
5. Make `HarborUnit` implement `Comparable<HarborUnit>` by id and sort the final report.

---

## Suggested build order (don't write it all at once)

1. `enum`s → `Container` → the 4 exceptions
2. The 3 interfaces
3. `HarborUnit`
4. `Truck` only + `Dock` slots only + a `Main` that runs 4 trucks → **get slot contention working**
5. Add `Dock` yard + `Crane` → **get wait/notify working**
6. Add `Forklift`, `Ship`
7. Add `ControlTower` last
8. Bonus rounds
