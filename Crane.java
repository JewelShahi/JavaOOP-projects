package HarborCargoSystem;

class Crane extends HarborUnit implements Loadable, Maintainable, Runnable {

    private final double capacity;
    private Container held;
    private int faultCount;
    private final Dock dock;

    public Crane(String id, String location, double capacity, Container held, int faultCount, Dock dock) {
        super(id, location);
        this.capacity = capacity;
        this.held = held;
        this.faultCount = faultCount;
        this.dock = dock;
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    public Container getHeld() {
        synchronized (lock) {
            return held;
        }
    }

    @Override
    public int getFaultCount() {
        synchronized (lock) {
            return faultCount;
        }
    }

    public Dock getDock() {
        return dock;
    }

    @Override
    public double getCurrentWeight() {
        synchronized (lock) {
            return held == null ? 0 : held.getWeight();
        }
    }

    @Override
    public void load(Container c) throws OverloadException, UnitOfflineException {
        synchronized (lock) {
            requireOnline();

            if (held != null)
                throw new OverloadException(getId(), getCurrentWeight() + c.getWeight(), capacity);

            if (c.getWeight() > capacity)
                throw new OverloadException(getId(), c.getWeight(), capacity);

            held = c;
        }
    }

    @Override
    public Container unload() throws UnitOfflineException {
        synchronized (lock) {
            requireOnline();

            if (held == null)
                return null;

            Container container = held;
            held = null;

            return container;
        }
    }

    @Override
    public void performShift() throws HarborException, InterruptedException {
        ping();
        requireOnline();

        Container container = dock.takeContainer();

        System.out.println(Thread.currentThread().getName() + " picked container");

        try {
            load(container);

            if (Math.random() < 0.1) {
                reportFault("cable slip");
                throw new UnitOfflineException(getId(), getCurrentStatus());
            }

            Thread.sleep(500);

            Container moved = unload();

            if (moved != null)
                dock.storeContainer(moved);

        } catch (HarborException | InterruptedException e) {
            synchronized (lock) {
                if (held != null) {
                    container = held;
                    held = null;
                }
            }

            dock.storeContainer(container);

            throw e;
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                performShift();

            } catch (UnitOfflineException e) {
                System.out.println(e.getMessage());
                break;

            } catch (HarborException e) {
                System.out.println(e.getMessage());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void reportFault(String reason) {
        synchronized (lock) {
            faultCount++;
            setStatus(UnitStatus.BROKEN);
        }

        System.out.println("[" + getId() + "] Fault: " + reason);
    }

    @Override
    public void repair() throws UnitOfflineException {
        synchronized (lock) {
            if (getCurrentStatus() == UnitStatus.OFFLINE)
                throw new UnitOfflineException(getId(), getCurrentStatus());

            if (getCurrentStatus() == UnitStatus.BROKEN)
                setStatus(UnitStatus.IDLE);
        }
    }

    @Override
    public String getUnitKind() {
        return "Crane";
    }
}