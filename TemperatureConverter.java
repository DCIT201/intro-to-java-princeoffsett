import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the conversion type
        System.out.println("Choose the conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        int choice = getValidChoice(scanner); // Get and validate choice

        // Prompt for temperature input
        System.out.print("Enter the temperature value: ");
        double temperature = getValidTemperature(scanner); // Get and validate temperature

        // Perform the conversion and display the result
        if (choice == 1) {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.%n", temperature, fahrenheit);
        } else {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f Fahrenheit is equal to %.2f Celsius.%n", temperature, celsius);
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    // Method to get and validate the user's menu choice
    public static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break; // Valid choice
                } else {
                    System.out.println("Invalid choice. Please enter 1 for Celsius to Fahrenheit or 2 for Fahrenheit to Celsius.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return choice;
    }

    // Method to get and validate the temperature input
    public static double getValidTemperature(Scanner scanner) {
        double temperature;
        while (true) {
            if (scanner.hasNextDouble()) {
                temperature = scanner.nextDouble();
                break; // Valid temperature
            } else {
                System.out.println("Invalid input. Please enter a valid number for temperature.");
                scanner.next(); // Clear the invalid input
            }
        }
        return temperature;
    }

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
