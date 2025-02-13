import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your First Name: ");
        String firstInput = scanner.nextLine();

        System.out.print("Enter your Last Name: ");
        String secondInput = scanner.nextLine();

        System.out.println("Hello: " + firstInput + " " + secondInput);

        char operator;
        double number1, number2, result;

        System.out.println("Choose an operator: +, -, *, or /");
        operator = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.println("Enter first number");
        number1 = scanner.nextDouble();

        System.out.println("Enter second number");
        number2 = scanner.nextDouble();

        switch (operator) {
            case '+':
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;

            case '-':
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;

            case '*':
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;

            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                    System.out.println(number1 + " / " + number2 + " = " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }

        System.out.print("Enter the first distance in kilometers: ");
        double distance1 = scanner.nextDouble();

        System.out.print("Enter the second distance in kilometers: ");
        double distance2 = scanner.nextDouble();

        double totalDistance = distance1 + distance2;
        System.out.println("The total distance is: " + totalDistance + " kilometers");

        System.out.print("Enter a maximum value: ");
        int maxValue = scanner.nextInt();

        Random random = new Random();
        int randomNumber = random.nextInt(maxValue) + 1;

        System.out.println("Randomly selected number: " + randomNumber);

        System.out.println("Looping through numbers from 1 to " + randomNumber + ":");
        for (int i = 1; i <= randomNumber; i++) {
            System.out.println(i);
        }

        // Append reversed word to file
        while (true) {
            System.out.print("Enter a word to reverse (or type 'exit' to quit): ");
            String word = scanner.nextLine();

            if (word.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            StringBuilder reversedWord = new StringBuilder(word).reverse();
            System.out.println("Reversed word: " + reversedWord);

            // Save the reversed word into the file, append if file already exists
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("reversedWord.txt", true))) {
                writer.write("Original word: " + word + "\n");
                writer.write("Reversed word: " + reversedWord + "\n\n");
                System.out.println("Reversed word has been saved to 'reversedWord.txt'.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
