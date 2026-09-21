package HarborCargoSystem;

import java.util.LinkedList;
import java.util.Queue;

public class Dock {

    private final int totalSlots;
    private int freeSlots;
    private final Queue<Container> yard = new LinkedList<>();
    private final int yardCapacity;

    private final Object slotLock = new Object();
    private final Object yardLock = new Object();

    public Dock(int totalSlots, int yardCapacity) {
        this.totalSlots = totalSlots;
        this.freeSlots = totalSlots;
        this.yardCapacity = yardCapacity;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public int getFreeSlots() {
        synchronized (slotLock) {
            return freeSlots;
        }
    }

    public int getYardCapacity() {
        return yardCapacity;
    }

    public void acquireSlot(HarborUnit unit) throws SlotUnavailableException, InterruptedException {
        synchronized (slotLock) {

            long endTime = System.currentTimeMillis() + 3000;

            while (freeSlots == 0) {

                long remainingTime = endTime - System.currentTimeMillis();

                if (remainingTime <= 0)
                    throw new SlotUnavailableException(unit.getId(), totalSlots);

                slotLock.wait(remainingTime);
            }

            freeSlots--;
        }
    }

    public void releaseSlot(HarborUnit unit) {
        synchronized (slotLock) {

            if (freeSlots < totalSlots)
                freeSlots++;

            slotLock.notifyAll();
        }
    }

    public void storeContainer(Container container) throws InterruptedException {
        synchronized (yardLock) {

            while (yard.size() >= yardCapacity)
                yardLock.wait();

            yard.add(container);

            yardLock.notifyAll();
        }
    }

    public Container takeContainer() throws InterruptedException {
        synchronized (yardLock) {

            while (yard.isEmpty())
                yardLock.wait();

            Container container = yard.poll();

            yardLock.notifyAll();

            return container;
        }
    }

    @Override
    public String toString() {
        synchronized (slotLock) {
            synchronized (yardLock) {
                return "Dock{" +
                        "totalSlots=" + totalSlots +
                        ", freeSlots=" + freeSlots +
                        ", yard=" + yard +
                        ", yardCapacity=" + yardCapacity +
                        '}';
            }
        }
    }
}