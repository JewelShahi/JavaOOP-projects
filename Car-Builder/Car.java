class Car {
  public String manufacturer;
  public String model;
  public String type;
  public String color;
  public String chassisNumber;
  public String carNumber;

  public Car(String manufacturer, String model, String type, String color, String chassisNumber, String carNumber) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.type = type;
    this.color = color;
    this.chassisNumber = chassisNumber;
    this.carNumber = carNumber;
  }

  public String toString() {
    return "Manufacturer: " + manufacturer + "\nModel: " + model + "\nType: " + type +
        "\nColor: " + color + "\nChassis Number: " + chassisNumber + "\nCar Number: " + carNumber;
  }
}
