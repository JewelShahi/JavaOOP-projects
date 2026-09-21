package HarborCargoSystem;

public class Main {

    public static void main(String[] args) {
        System.out.println("MAIN STARTED");

        try {

            Dock dock = new Dock(3, 10);

            Truck truck1 = new Truck("TRUCK-1", "Gate-A", 1000, dock);
            Truck truck2 = new Truck("TRUCK-2", "Gate-B", 1000, dock);
            Truck truck3 = new Truck("TRUCK-3", "Gate-C", 1000, dock);
            Truck truck4 = new Truck("TRUCK-4", "Gate-D", 1000, dock);

            Crane crane1 = new Crane("CRANE-1", "Yard-A", 500, null, 0, dock);
            Crane crane2 = new Crane("CRANE-2", "Yard-B", 500, null, 0, dock);

            Forklift forklift = new Forklift("FORK-1", "Zone-A", 300, dock, "Zone-A", "Zone-B");

            Ship ship = new Ship("SHIP-1", "Harbor", 20, dock);

            ControlTower tower = new ControlTower("TOWER-1", "Center");

            tower.watch(truck1);
            tower.watch(truck2);
            tower.watch(truck3);
            tower.watch(truck4);

            tower.watch(crane1);
            tower.watch(crane2);

            tower.watch(forklift);
            tower.watch(ship);

            for (int i = 1; i <= 12; i++) {

                CargoType type;

                switch (i % 4) {

                    case 0:
                        type = CargoType.HAZARDOUS;
                        break;

                    case 1:
                        type = CargoType.GENERAL;
                        break;

                    case 2:
                        type = CargoType.FRAGILE;
                        break;

                    default:
                        type = CargoType.REFRIGERATED;
                }

                ship.load(new Container("C-" + i, 50 * i, type));
            }

            Thread truckThread1 =
                    new Thread(truck1, "truck-1");

            Thread truckThread2 =
                    new Thread(truck2, "truck-2");

            Thread truckThread3 =
                    new Thread(truck3, "truck-3");

            Thread truckThread4 =
                    new Thread(truck4, "truck-4");

            Thread craneThread1 =
                    new Thread(crane1, "crane-1");

            Thread craneThread2 =
                    new Thread(crane2, "crane-2");

            Thread towerThread =
                    new Thread(tower, "tower");

            truckThread1.start();
            truckThread2.start();
            truckThread3.start();
            truckThread4.start();

            craneThread1.start();
            craneThread2.start();

            towerThread.start();

            ship.performShift();

            Thread.sleep(10000);

            truck1.stop();
            truck2.stop();
            truck3.stop();
            truck4.stop();

            craneThread1.interrupt();
            craneThread2.interrupt();
            towerThread.interrupt();

            truckThread1.join();
            truckThread2.join();
            truckThread3.join();
            truckThread4.join();

            craneThread1.join();
            craneThread2.join();

            towerThread.join();

            System.out.println("===== FINAL REPORT =====");

            int totalFaults =
                    crane1.getFaultCount()
                            + crane2.getFaultCount()
                            + forklift.getFaultCount();

            System.out.printf(
                    "Total faults: %d%n",
                    totalFaults
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}