package task3;
import java.util.Scanner;

public class Task3 {

  public static void main(String[] args) {
    BankAccount account = new BankAccount("John Doe", 1000.0);

    
    Scanner scanner = new Scanner(System.in);
    // Display a menu with options
    System.out.println("\nWelcome to the Bank Account Management System");
    System.out.println("1: Check balance");
    System.out.println("2: Make deposit");
    System.out.println("3: Make withdrawal");
    System.out.println("4: Display account info");
    System.out.println("0: Exit");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

    while (choice != 0) {

      // if choice is 1, check balance
      if (choice == 1) {
        System.out.println("Your balance is: $" + account.getBalance());

        // if choice is 2, make deposit
      } else if (choice == 2) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
          System.out.println("Deposit successful.");
        } else {
          System.out.println("Invalid deposit amount.");
        }
        System.out.println("Your balance is: $" + account.getBalance());

        // if choice is 3, make withdrawal
      } else if (choice == 3) {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
          System.out.println("Withdrawal successful.");
        } else {
          System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
        System.out.println("Your balance is: $" + account.getBalance());

        // if choice is 4, display account info
      } else if (choice == 4) {
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Balance: $" + account.getBalance());

        // if choice is invalid, display error message
      } else {
        System.out.println("Invalid choice. Please try again.");
      }

      // Display the menu again
      System.out.println("\n What would you like to do next?");
      System.out.println("1: Check balance");
      System.out.println("2: Make deposit");
      System.out.println("3: Make withdrawal");
      System.out.println("4: Display account info");
      System.out.println("0: Exit");

      choice = scanner.nextInt();
    }

    System.out.println("Thank you for using the Bank Account Management System. Goodbye!");
    scanner.close();
  }
}