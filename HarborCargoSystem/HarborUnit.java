package HarborCargoSystem;

public abstract class HarborUnit implements Trackable {

    private final String id;
    private String location;
    private volatile UnitStatus status;
    private volatile long lastPingMillis;

    protected final Object lock = new Object();

    public HarborUnit(String id, String location) {
        this.id = id;
        this.location = location;

        this.status = UnitStatus.IDLE;
        this.lastPingMillis = System.currentTimeMillis();
    }

    public abstract void performShift() throws HarborException, InterruptedException; // the unit's main job
    public abstract String getUnitKind();

    @Override
    public String getId(){
        return this.id;
    }

    @Override
    public String getLocation(){
        return this.location;
    }

    synchronized void setLocation(String location){
        this.location = location;
    }

    public UnitStatus getCurrentStatus(){
        return this.status;
    }

    public void setStatus(UnitStatus status){
        this.status = status;
    }

    @Override
    public long getLastPingMillis(){
        return this.lastPingMillis;
    }

    public void ping(){
        this.lastPingMillis = System.currentTimeMillis();
    }

    protected void requireOnline() throws UnitOfflineException {
        if(this.status == UnitStatus.BROKEN || this.status == UnitStatus.OFFLINE)
            throw new UnitOfflineException(getId(), getCurrentStatus());
    }

    @Override public String toString(){
        return String.format(
                "HarbourUnit={\nid=%s\nlocation=%s\nstatus=%s\nlastPingMillis=%d}",
                getId(), getLocation(), getCurrentStatus(), getLastPingMillis()
        );
    }
}
