package HarborCargoSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Truck extends HarborUnit implements Loadable, Runnable {

    private final double capacity;
    private final List<Container> cargo = new ArrayList<>();
    private final Dock dock;
    private volatile boolean running = true;

    public Truck(String id, String location, double capacity, Dock dock) {
        super(id, location);
        this.capacity = capacity;
        this.dock = dock;
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    public Dock getDock() {
        return dock;
    }

    @Override
    public double getCurrentWeight() {
        synchronized (lock) {
            double totalWeight = 0;

            for (Container container : cargo)
                totalWeight += container.getWeight();

            return totalWeight;
        }
    }

    @Override
    public void load(Container c) throws OverloadException, UnitOfflineException {
        synchronized (lock) {
            requireOnline();

            if (getCurrentWeight() + c.getWeight() > capacity)
                throw new OverloadException(
                        getId(),
                        getCurrentWeight() + c.getWeight(),
                        capacity
                );

            cargo.add(c);
        }
    }

    @Override
    public Container unload() throws UnitOfflineException {
        synchronized (lock) {
            requireOnline();

            if (cargo.isEmpty())
                return null;

            return cargo.remove(cargo.size() - 1);
        }
    }

    @Override
    public void performShift() throws HarborException, InterruptedException {
        ping();
        requireOnline();

        dock.acquireSlot(this);

        try {
            setStatus(UnitStatus.WORKING);

            Thread.sleep(
                    ThreadLocalRandom.current().nextInt(200, 601)
            );

        } finally {
            dock.releaseSlot(this);

            if (getCurrentStatus() == UnitStatus.WORKING)
                setStatus(UnitStatus.IDLE);
        }
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
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

    public void stop() {
        running = false;
    }

    @Override
    public String getUnitKind() {
        return "Truck";
    }
}
