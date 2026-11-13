package task2;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) throws Exception {
        // START

        // Display "Moin!"
        System.out.println("\nMoin!");

        // Create Random object
        Random rand = new Random();
        // Generate random number between 1 and 100
        int randomNumber = rand.nextInt(100) + 1;

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize attempts counter
        int attempts = 1;

        boolean gameRunning = true;
        while (gameRunning) {
            // Ask user for their guess
            System.out.print("Enter your guess (1-100): ");
            int userGuess = scanner.nextInt();

            
            // Check if the guess is correct, too high, or too low
            if (userGuess == randomNumber) {
              System.out.println("You guessed it!: " + randomNumber);
              System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
              gameRunning = false; // End the game
            } else if (userGuess < randomNumber) {
              System.out.println("Too low! Try again.");
            } else {
              System.out.println("Too high! Try again.");
            }

            attempts++;
        }

        // Close the scanner
        scanner.close();
    }

}
