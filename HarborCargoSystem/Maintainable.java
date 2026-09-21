package HarborCargoSystem;

public interface Maintainable {
    void reportFault(String reason);
    void repair() throws UnitOfflineException;
    int getFaultCount();

    static boolean needsUrgentService(Maintainable m) {
        return m.getFaultCount() >= 3;
    }
}
