import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Create a FamilialCar object
    System.out.println("Enter data for a FamilialCar:");
    System.out.print("Manufacturer: ");
    String familialManufacturer = scanner.nextLine();
    System.out.print("Model: ");
    String familialModel = scanner.nextLine();
    System.out.print("Type: ");
    String familialType = scanner.nextLine();
    System.out.print("Color: ");
    String familialColor = scanner.nextLine();
    System.out.print("Chassis number: ");
    String familialChassisNumber = scanner.nextLine();
    System.out.print("Car number: ");
    String familialCarNumber = scanner.nextLine();
    System.out.print("Usage toll (leva per day): ");
    double familialUsageToll = scanner.nextDouble();
    System.out.print("fuelusage: ");
    double fuelusage = scanner.nextDouble();
    scanner.nextLine(); // Consume the leftover newline character
    FamilialCar familialCar = new FamilialCar(familialManufacturer, familialModel, familialType, familialColor,
        familialChassisNumber, familialCarNumber, familialUsageToll);

    // Create a LuxuriousCar object
    System.out.println("\nEnter data for a LuxuriousCar:");
    System.out.print("Manufacturer: ");
    String luxuriousManufacturer = scanner.nextLine();
    System.out.print("Model: ");
    String luxuriousModel = scanner.nextLine();
    System.out.print("Type: ");
    String luxuriousType = scanner.nextLine();
    System.out.print("Color: ");
    String luxuriousColor = scanner.nextLine();
    System.out.print("Chassis number: ");
    String luxuriousChassisNumber = scanner.nextLine();
    System.out.print("Car number: ");
    String luxuriousCarNumber = scanner.nextLine();
    System.out.print("Usage toll (leva per day): ");
    double luxuriousUsageToll = scanner.nextDouble();
    scanner.nextLine(); // Consume the leftover newline character
    System.out.print(
        "Additional extras:\n1. Champagne (100 leva)\n2. Wine (50 leva)\n3. Chocolate (40 leva)\nEnter the number of the extra you want to add (or 0 for no extra): ");
    double luxuriousExtra = scanner.nextDouble();
    scanner.nextLine(); // Consume the leftover newline character
    LuxuriousCar luxuriousCar = new LuxuriousCar(luxuriousManufacturer, luxuriousModel, luxuriousType,
        luxuriousColor, luxuriousChassisNumber,
        luxuriousCarNumber, luxuriousUsageToll,
        luxuriousExtra);

    // Calculate the rental prices for each car
    System.out.print("\nEnter the travelled distance for both cars (in kilometers): ");
    double familialDistance = scanner.nextDouble();
    double luxuriousDistance = scanner.nextDouble();
    scanner.close();
    double familialPrice = familialCar.calculateRentalPrice(familialDistance);
    double luxuriousPrice = luxuriousCar.calculateRentalPrice(luxuriousExtra, luxuriousDistance);

    // Print the car information and rental prices
    System.out.println("\n" + familialCar.toString() +
        "\nTraveled distance: " + familialDistance +
        " km\nRental price: " + familialPrice + " leva");
    System.out.println("\n" + luxuriousCar.toString() +
        "\nTraveled distance: " + luxuriousDistance +
        " km\nRental price: " + luxuriousPrice + " leva");
  }
}
