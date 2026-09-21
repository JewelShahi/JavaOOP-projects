package HarborCargoSystem;

import java.util.Objects;

public class Forklift extends HarborUnit
        implements Loadable, Maintainable {

    private final double capacity;
    private Container held;
    private int faultCount;
    private final Dock dock;

    private String sourceZone;
    private String destinationZone;

    public Forklift(
            String id,
            String location,
            double capacity,
            Dock dock,
            String sourceZone,
            String destinationZone) {

        super(id, location);

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero"
            );
        }

        this.capacity = capacity;
        this.dock = Objects.requireNonNull(dock, "dock");
        this.sourceZone = Objects.requireNonNull(
                sourceZone,
                "sourceZone"
        );
        this.destinationZone = Objects.requireNonNull(
                destinationZone,
                "destinationZone"
        );
    }

    @Override
    public void load(Container container) throws OverloadException, UnitOfflineException {

        Objects.requireNonNull(container, "container");

        synchronized (lock) {
            requireOnline();

            if (container.getCargoType() == CargoType.HAZARDOUS || container.getCargoType() == CargoType.REFRIGERATED)
                throw new OverloadException(getId(), container.getWeight(), capacity);

            if (held != null)
                throw new OverloadException(getId(), getCurrentWeight() + container.getWeight(), capacity);

            if (container.getWeight() > capacity)
                throw new OverloadException(getId(), container.getWeight(), capacity);

            held = container;
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
    public double getCurrentWeight() {
        synchronized (lock) {
            return held == null ? 0 : held.getWeight();
        }
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    @Override
    public void reportFault(String reason) {

        synchronized (lock) {
            faultCount++;
            setStatus(UnitStatus.BROKEN);
        }

        System.out.printf("[%s] Forklift fault: %s%n", getId(), reason);
    }

    @Override
    public void repair() throws UnitOfflineException {

        synchronized (lock) {
            UnitStatus currentStatus = getCurrentStatus();
            if (currentStatus == UnitStatus.OFFLINE)
                throw new UnitOfflineException(getId(), currentStatus);

            if (currentStatus == UnitStatus.BROKEN)
                setStatus(UnitStatus.IDLE);
        }
    }

    @Override
    public int getFaultCount() {
        synchronized (lock) {
            return faultCount;
        }
    }

    @Override
    public void performShift() throws HarborException, InterruptedException {

        ping();

        requireOnline();
        Container container = dock.takeContainer();

        try {
            load(container);
        } catch (HarborException exception) {
            dock.storeContainer(container);
            throw exception;
        }

        setStatus(UnitStatus.WORKING);
        setLocation(sourceZone);

        try {

            Thread.sleep(300);

            setLocation(destinationZone);
            Container movedContainer = unload();

            if (movedContainer != null)
                dock.storeContainer(movedContainer);

            swapZones();
        } catch (InterruptedException exception) {
            returnHeldContainerToDock();
            Thread.currentThread().interrupt();
            throw exception;
        } finally {
            if (getCurrentStatus() == UnitStatus.WORKING)
                setStatus(UnitStatus.IDLE);
        }
    }

    private void returnHeldContainerToDock() throws InterruptedException {
        Container container;
        synchronized (lock) {
            container = held;
            held = null;
        }
        if (container != null)
            dock.storeContainer(container);
    }

    private void swapZones() {
        synchronized (lock) {
            String temporaryZone = sourceZone;
            sourceZone = destinationZone;
            destinationZone = temporaryZone;
        }
    }

    @Override
    public String getUnitKind() {
        return "Forklift";
    }
}
