class FamilialCar extends Car {
  double usageToll;
  double travelledDistance;

  public FamilialCar(String manufacturer, String model, String type, String color, String chassisNumber,
      String carNumber, double usageToll) {
    super(manufacturer, model, type, color, chassisNumber, carNumber);
    this.usageToll = usageToll;
  }

  public double calculateRentalPrice(double travelledDistance) {
    if (travelledDistance < 500) {
      return usageToll * travelledDistance * 0.7;
    } else {
      return usageToll * travelledDistance * 0.4;
    }
  }

  public String toString() {
    return super.toString() + "\nUsage Toll: " + usageToll;
  }
}
