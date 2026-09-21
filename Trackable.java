package HarborCargoSystem;

public interface Trackable {

    String getId();
    String getLocation();
    long getLastPingMillis();

    default boolean isStale() {
        return System.currentTimeMillis() - getLastPingMillis() > 5000;
    }
}
