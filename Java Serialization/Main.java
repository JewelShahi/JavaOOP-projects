import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] numbers = { 5, 2, 9, 1, 7 };
        try {
            FileOutputStream fileOut = new FileOutputStream("numbers.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(numbers);
            objectOut.close();
            fileOut.close();

            System.out.println("Масивът е записан във файл.");

            FileInputStream fileIn = new FileInputStream("numbers.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int[] numbersFromFile = (int[]) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            for (int i = 0; i < numbersFromFile.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < numbersFromFile.length; j++) {
                    if (numbersFromFile[j] < numbersFromFile[minIndex]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    int temp = numbersFromFile[i];
                    numbersFromFile[i] = numbersFromFile[minIndex];
                    numbersFromFile[minIndex] = temp;
                }
            }

            System.out.println("Масивът е сортиран.");
            for (int i : numbersFromFile)
                System.out.print(i + " ");

            FileOutputStream fileOutSorted = new FileOutputStream("sortedNumbers.bin");
            ObjectOutputStream objectOutSorted = new ObjectOutputStream(fileOutSorted);
            objectOutSorted.writeObject(numbersFromFile);
            objectOutSorted.close();
            fileOutSorted.close();
            System.out.println("Сортираният масив е записан във файл.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
