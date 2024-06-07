import java.util.*;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a new number");
            System.out.println("2. Remove a number");
            System.out.println("3. Display all numbers");
            System.out.println("4. Sort numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter number: ");
                    String number = scan.nextLine();
                    phoneBook.addNumber(name, number);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scan.nextLine();
                    phoneBook.removeNumber(name);
                    break;
                case 3:
                    phoneBook.displayNumbers();
                    break;
                case 4:
                    phoneBook.sortNumbers();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
