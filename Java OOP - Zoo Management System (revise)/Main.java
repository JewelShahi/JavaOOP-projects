
// Importing libraries
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Lion lion1 = new Lion("Leo", 5);
        System.out.println("Enter the name and than the age of the lion: ");
        Lion lion2 = new Lion(scan.nextLine(), scan.nextInt());

        Elephant elephant = new Elephant("Ella", 10);
        Monkey monkey = new Monkey("Momo", 3);

        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(elephant);
        zoo.addAnimal(monkey);

        System.out.println("All animals make sound:");
        zoo.makeAllAnimalsSound();

        System.out.println("\nPerforming custom action on all animals:");
        zoo.performActionOnAllAnimals(
                animal -> System.out.println(animal.getName() + " is " + animal.getAge() + " years old"));

        scan.close();
    }
}
