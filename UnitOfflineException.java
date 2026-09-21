package HarborCargoSystem;

public class UnitOfflineException extends HarborException {
    private final UnitStatus currentStatus;

    public UnitOfflineException(String unitId, UnitStatus currentStatus){
        super("Unit is " + currentStatus + " and cannot accept commands", unitId);
        this.currentStatus = currentStatus;
    }

    public UnitStatus getCurrentStatus(){
        return this.currentStatus;
    }
}
