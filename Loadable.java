package HarborCargoSystem;

public interface Loadable {
    void load(Container c) throws OverloadException, UnitOfflineException;
    Container unload() throws UnitOfflineException;   // returns null if empty
    double getCurrentWeight();
    double getCapacity();

    default double getFreeSpace() {
        return getCapacity() - getCurrentWeight();
    }
}
