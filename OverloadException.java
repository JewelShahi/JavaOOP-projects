package HarborCargoSystem;

public class OverloadException extends HarborException{
    private final double attemptWeight;
    private final double capacity;

    public OverloadException(String unitId, double attemptWeight, double capacity){
        super(String.format("Tried %fkg but capacity is %fkg", attemptWeight, capacity), unitId);

        this.attemptWeight = attemptWeight;
        this.capacity = capacity;
    }

    public double getAttemptWeight(){
        return this.attemptWeight;
    }

    public double getCapacity(){
        return this.capacity;
    }
}
