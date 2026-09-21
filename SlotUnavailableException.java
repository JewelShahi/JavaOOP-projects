package HarborCargoSystem;

public class SlotUnavailableException extends HarborException {

    private final int totalSlots;

    public SlotUnavailableException(String unitId, int totalSlots){
        super("No free slot after timeout (all " + totalSlots + " occupied)", unitId);
        this.totalSlots = totalSlots;
    }

    public int getTotalSlots(){
        return this.totalSlots;
    }
}
