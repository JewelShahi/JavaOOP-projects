package HarborCargoSystem;

public class HarborException extends Exception{
    private final String unitId;

    public HarborException(String message, String unitId) {
        super(message);
        this.unitId = unitId;
    }

    public HarborException(String message, String unitId, Throwable cause){
        super(message, cause);

        this.unitId = unitId;
    }

    public String getUnitId(){
        return this.unitId;
    }

    @Override
    public String getMessage(){
        return String.format("[%s] %s", getUnitId(), super.getMessage());
    }
}
