package task3;

public class BankAccount {

  private double balance;
  private String accountHolder;

  // Constructor to initialize the account holder and initial balance
  public BankAccount(String accountHolder, double initialBalance) {
    this.accountHolder = accountHolder;
    this.balance = initialBalance;
  }


  // Method to deposit money into the account
  public boolean deposit(double amount) {
    // Check if the deposit amount is positive
    if (amount > 0) {
      this.balance += amount;
      return true;
    } else {
      return false;
    }
  }

  // Method to withdraw money from the account
  public boolean withdraw(double amount) {
    // Check if the withdrawal amount is positive,
    // and less than or equal to the current balance
    if (amount > 0 && amount <= this.balance) {
      this.balance -= amount;
      return true;
    } else {
      return false;
    }
  }

  //Getters
  public double getBalance() {
    return this.balance;
  }

  public String getAccountHolder() {
    return this.accountHolder;
  }

}
