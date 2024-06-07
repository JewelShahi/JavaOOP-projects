import java.util.*;

public class PhoneBook {
    private Map<String, String> phoneNumbers;

    public PhoneBook() {
        phoneNumbers = new HashMap<>();
    }

    public void addNumber(String name, String number) {
        if (!number.matches("^\\+359(87|88|89)[2-9][0-9]{6}")) {
            System.out.println("Invalid phone number. Phone numbers in Bulgaria should start with +359, followed by 87, 88, or 89, then a digit between 2 and 9, and finally 6 random digits.");
            return;
        }
        phoneNumbers.put(name, number);
    }

    public void removeNumber(String name) {
        phoneNumbers.remove(name);
    }

    public void displayNumbers() {
        for (String name : phoneNumbers.keySet()) {
            System.out.println(name + ": " + phoneNumbers.get(name));
        }
    }

    public String getNumber(String name) {
        return phoneNumbers.get(name);
    }

    public void sortNumbers() {
        Map<String, String> sortedPhoneNumbers = new TreeMap<>(phoneNumbers);
        phoneNumbers = sortedPhoneNumbers;
    }
}
