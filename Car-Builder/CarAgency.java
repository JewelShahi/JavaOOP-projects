import java.util.*;

public class CarAgency {

  public static void main(String[] args) {

    // Create some instances of FamilialCar and LuxuriousCar
    FamilialCar famCar1 = new FamilialCar("Toyota", "Corolla", "Combi", "blue", "1234", "123-A",
        10);

    FamilialCar famCar2 = new FamilialCar("Honda", "Civic", "Sedan", "red", "5678", "456-B", 8);

    LuxuriousCar luxCar1 = new LuxuriousCar("Mercedes-Benz", "S-Class", "Sedan", "black", "9012",
        "789-C", 100, 0.4);

    LuxuriousCar luxCar2 = new LuxuriousCar("BMW", "X5", "SUV", "white", "3456", "012-D", 200,
        0.6);

    // Calculate and print the rental price for each car
    System.out.println("Rental price for familial car 1: " +
        famCar1.calculateRentalPrice(200));

    System.out.println("Rental price for familial car 2: " +
        famCar2.calculateRentalPrice(600));

    System.out.println("Rental price for luxurious car 1 with champagne: " +
        luxCar1.calculateRentalPrice(100, 150));

    System.out.println("Rental price for luxurious car 2 with wine: " +
        luxCar2.calculateRentalPrice(50, 300));

    // Store the cars in a data structure
    ArrayList<Car> cars = new ArrayList<Car>();

    cars.add(famCar1);

    cars.add(famCar2);

    cars.add(luxCar1);

    cars.add(luxCar2);

    // Print the details of each car in the data structure
    for (Car car : cars) {

      System.out.println(car.toString());

    }

  }

}
