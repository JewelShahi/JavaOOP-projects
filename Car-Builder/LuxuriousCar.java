class LuxuriousCar extends Car {
  double usageToll;
  double travelledDistance;
  double additionalExtrasToll;

  public LuxuriousCar(String manufacturer, String model, String type, String color, String chassisNumber,
      String carNumber, double usageToll, double additionalExtrasToll) {
    super(manufacturer, model, type, color, chassisNumber, carNumber);
    this.usageToll = usageToll;
    this.additionalExtrasToll = additionalExtrasToll;
  }

  public double calculateRentalPrice(double additionalExtrasToll, double travelledDistance) {
    double coefficient;
    if (travelledDistance < 200) {
      coefficient = 0.6;
    } else {
      coefficient = 0.4;
    }
    return usageToll * travelledDistance * coefficient + additionalExtrasToll;
  }

  public String toString() {
    return super.toString() + "\nUsage Toll: " + usageToll +
        "\nAdditional Extras Toll: " + additionalExtrasToll;
  }
}
