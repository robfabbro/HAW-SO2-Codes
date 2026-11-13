package task3;
import java.util.Scanner;

public class Task3 {

  public static void main(String[] args) {
    System.out.println("\nMoin!");

    // Create Scanner object for user input
    Scanner scanner = new Scanner(System.in);

    // Ask user for Roman numeral input
    System.out.print("Enter a Roman numeral: ");
    String romanNumeral = scanner.nextLine();

    // Convert Roman numeral to integer
    int integerValue = romanToInt(romanNumeral);

    // Display the result
    System.out.println("The integer value of " + romanNumeral + " is: " + integerValue);

    // Close the scanner
    scanner.close();

  }

  // Helper Method 1: Convert Roman numeral to integer
  public static int romanToInt(String s) {
    // Initialize total and previous value of the Roman numeral
    int total = 0;
    int prevValue = 0;

    // Iterate through the Roman numeral string from right to left
    for (int i = s.length() - 1; i >= 0; i--) {
      // Get the current Roman character
      char c = s.charAt(i);
      // and get its integer value from the second helper method
      int currentValue = romanCharToInt(c);

      // If the current value is less than the previous value
      // then subtract it from the total
      if (currentValue < prevValue) {
        total -= currentValue;
      } else { // otherwise, add it to the total
        total += currentValue;
      }

      // Update the previous value for the next iteration
      prevValue = currentValue;
    }

    // Return the total integer value
    return total;
  }

  // Helper Method 2: Convert a single Roman character to its integer value
  public static int romanCharToInt(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0; // Invalid character
    }
  }
}
