package HarborCargoSystem;

import java.util.*;

public class Ship extends HarborUnit implements Loadable {

    private final int maxContainers;
    private final Deque<Container> hold = new ArrayDeque<>();
    private final Dock dock;

    public Ship(String id, String location, int maxContainers, Dock dock) {
        super(id, location);

        this.maxContainers = maxContainers;
        this.dock = dock;
    }

    @Override
    public void load(Container container) throws OverloadException, UnitOfflineException {

        synchronized (lock) {
            requireOnline();

            if (hold.size() >= maxContainers)
                throw new OverloadException(getId(), hold.size() + 1, maxContainers);

            hold.push(container);
        }
    }

    @Override
    public Container unload() throws UnitOfflineException {

        synchronized (lock) {
            requireOnline();

            if (hold.isEmpty())
                return null;

            return hold.pop();
        }
    }

    @Override
    public double getCurrentWeight() {
        synchronized (lock) {

            double total = 0;

            for (Container container : hold)
                total += container.getWeight();

            return total;
        }
    }

    @Override
    public double getCapacity() {
        return maxContainers;
    }

    @Override
    public void performShift() throws HarborException, InterruptedException {

        synchronized (lock) {

            ping();

            requireOnline();

            while (!hold.isEmpty()) {
                Container container = unload();

                if (container != null)
                    dock.storeContainer(container);
            }
        }
    }

    @Override
    public boolean isStale() {
        return System.currentTimeMillis() - getLastPingMillis() > 30000;
    }

    @Override
    public String getUnitKind() {
        return "Ship";
    }
}
