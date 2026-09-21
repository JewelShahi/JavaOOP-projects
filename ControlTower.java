package HarborCargoSystem;

import java.util.*;
import java.util.concurrent.*;

public class ControlTower extends HarborUnit implements Runnable {

    private final List<Trackable> watched = new CopyOnWriteArrayList<>();

    public ControlTower(String id, String location) {
        super(id, location);
    }

    public void watch(Trackable trackable) {
        watched.add(trackable);
    }

    public void unwatch(Trackable trackable) {
        watched.remove(trackable);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                performShift();
                Thread.sleep(1000);
            } catch (HarborException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void performShift() throws HarborException {
        System.out.println("========== CONTROL TOWER ==========");

        for (Trackable trackable : watched) {
            System.out.printf("%s | %s | stale=%b%n", trackable.getId(), trackable.getLocation(), trackable.isStale());
        }

        System.out.println("===================================");
    }

    @Override
    public String getUnitKind() {
        return "ControlTower";
    }
}