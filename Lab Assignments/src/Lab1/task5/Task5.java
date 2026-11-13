package task5;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        // initialise the scanner
        Scanner scanner = new Scanner(System.in);

        // set the continueCalculating boolean that drives the while loop
        boolean continueCalculating = true;

        while (continueCalculating) {
            // Print out the display menu to the user
            System.out.println("\n=== Simple Calculator ===");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("Choose an operation (1-5): \n");

            // read the user's input
            int choice = scanner.nextInt();

            // if the user chooses 5, then we break the loop and print a thank you message
            if (choice == 5) {
                continueCalculating = false;
                System.out.print("\033[0;36m"); // Set text color to cyan
                System.out.println("\nThank you for using the calculator!\n");
                System.out.print("\033[0;0m"); // Set text color to default
                break;
            }

            // Otherwise we prompt for two numbers and read their inputs
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // initialise a variable to store the result,
            double result = 0;
            // and a boolean to handle the division by 0 case
            boolean validOperation = true;
            String operationUsed = "";

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    operationUsed = " + ";
                    break;
                case 2:
                    result = subtract(num1, num2);
                    operationUsed = " - ";
                    break;
                case 3:
                    result = multiply(num1, num2);
                    operationUsed = " * ";
                    break;
                case 4:
                    if (num2 != 0) {
                        result = divide(num1, num2);
                        operationUsed = " / ";
                    } else { // if we divide by 0, print an error and mark the operation as invalid
                        System.out.print("\033[0;31m"); // Set text color to red
                        System.out.println("\nError: Division by zero is not allowed.");
                        System.out.print("\033[0;0m"); // Set text color to default
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
                    validOperation = false;
            }

            // Display the result only if the operation performed was valid
            if (validOperation) {
                System.out.print("\033[0;32m"); // Set text color to green
                System.out.printf("\nResult: " + num1 + operationUsed + num2 + " = " + result + "\n");
                System.out.print("\033[0;0m"); // Set text color to default
            }
        }

        // close the scanner at the end of the program
        scanner.close();
    }

    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public static double divide(double a, double b) {
        return a / b;
    }

}
