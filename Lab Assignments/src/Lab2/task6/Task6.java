package task6;

import java.util.Scanner;

public class Task6 {

  public static void main(String[] args) {

    // initialise a scanner object
    Scanner scanner = new Scanner(System.in);

    // intialise a new inventory
    Inventory inventory = new Inventory();

    // Adding items to the inventory
    inventory.addItem(new Item("Laptop", 101, 10, 999.99));
    inventory.addItem(new Item("Smartphone", 102, 3, 499.99));
    inventory.addItem(new Item("Tablet", 103, 7, 299.99));
    inventory.addItem(new Item("Headphones", 104, 2, 79.99));
    inventory.addItem(new Item("Monitor", 105, 5, 199.99));

    // Display a menu with options
    System.out.println("\n\n********************************************");
    System.out.println("Welcome to the Inventory Management System");
    System.out.println("********************************************");

    System.out.println("\n\nWhat would you like to do next?");
    System.out.println("===========================================");
    System.out.println("1: Generate Inventory Report");
    System.out.println("2: Add an Item");
    System.out.println("3: Update Item Quantity");
    System.out.println("4: Search Item");
    System.out.println("5: Display Items with Low Stock Warnings");
    System.out.println("6: Calculate Total Inventory Value");
    System.out.println("0: Exit");
    System.out.println("===========================================");
    System.out.print("Enter your choice: ");

    int choice = scanner.nextInt();

    while (choice != 0) {

      switch (choice) {
        case 1: // Display Inventory Report
          inventory.generateReport();
          break;
        case 2: // Add an Item
          // need to ensure that the user input for item ID is unique, so we will check if
          // the item ID already exists in the inventory
          System.out.print("Enter item ID: ");
          int id = scanner.nextInt();
          while (inventory.findItemByID(id) != null) {
            System.out.println("Item ID already exists. \nPlease enter a unique item ID: ");
            id = scanner.nextInt();
          }

          // ask for user input for item name
          System.out.print("Enter item name: ");
          String name = scanner.next();
          // ensure tha the name is not empty or null and contains only letters and spaces
          while (name == null || name.trim().isEmpty() || !name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid input. \nPlease enter a valid item name (letters and spaces only): ");
            name = scanner.next();
          }

          // ask for user input for item quantity
          System.out.print("Enter item quantity: ");
          int quantity = scanner.nextInt();
          // ensure that the quantity is not negative
          while (quantity < 0) {
            System.out.println("Invalid input. \nPlease enter a valid item quantity (non-negative integer): ");
            quantity = scanner.nextInt();
          }

          // ask for user input for item price
          System.out.print("Enter item price: ");
          double price = scanner.nextDouble();
          // ensure that the price is not negative
          while (price < 0) {
            System.out.println("Invalid input. \nPlease enter a valid item price (non-negative number): ");
            price = scanner.nextDouble();
          }

          // create a new item object with the user input and add it to the inventory
          Item newItem = new Item(name, id, quantity, price);
          inventory.addItem(newItem);
          System.out.println("\n***** Item added successfully. *****");

          break;
        case 3: // Update Item Quantity
          System.out.print("Enter item ID to update quantity: ");
          int updateId = scanner.nextInt();
          // find the item by ID
          Item itemToUpdate = inventory.findItemByID(updateId);
          // if the item exists, ask for the new quantity and update it
          if (itemToUpdate != null) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();

            // ensure that the new quantity is not negative
            while (newQuantity < 0) {
              System.out.println("Invalid input. \nPlease enter a valid item quantity (non-negative integer): ");
              newQuantity = scanner.nextInt();
            }

            // update the item quantity
            itemToUpdate.setQuantity(newQuantity);
            System.out.println("\n***** Item quantity updated successfully. *****");

            // if the item does not exist, display an error message
          } else {
            System.out.println("\n***** Item not found. Returning to main menu. *****");
          }
          break;
        case 4: // Search Item
          // ask for user input on whether they want to search by name or ID
          System.out.println("Search by: ");
          System.out.println("1: Name");
          System.out.println("2: ID");
          System.out.print("Enter your choice: ");
          int searchChoice = scanner.nextInt();
          
          while (searchChoice != 1 && searchChoice != 2) {
            System.out.println("\nInvalid choice.\n");
            System.out.println("Search by: ");
            System.out.println("1: Name");
            System.out.println("2: ID");
            System.out.print("Enter your choice: ");
            searchChoice = scanner.nextInt();
          }

          if (searchChoice == 1) {
            // ask for user input for item name to search
            System.out.print("Enter item name to search: ");
            String searchName = scanner.next();
            // ensure that the name is not empty or null and contains only letters and
            // spaces
            while (searchName == null || searchName.trim().isEmpty() || !searchName.matches("[a-zA-Z ]+")) {
              System.out.println("Invalid input. \nPlease enter a valid item name (letters and spaces only): ");
              searchName = scanner.next();
            }

            // search for the item by name
            Item found = inventory.findItemByName(searchName);

            if (found != null) {
              found.displayItemDetails();
            } else {
              System.out.println("\n***** Item not found. Returning to main menu. *****");
            }

          } else if (searchChoice == 2) {
            // ask for user input for item ID to search
            System.out.print("Enter item ID to search: ");
            int searchId = scanner.nextInt();

            // ensure that the ID is not negative
            while (searchId < 0) {
              System.out.println("Invalid input. \nPlease enter a valid item ID (non-negative integer): ");
              searchId = scanner.nextInt();
            }

            // search for the item by ID
            Item found = null;
            found = inventory.findItemByID(searchId);

            // if the item exists, display its details
            if (found != null) {
              found.displayItemDetails();
            } else {
              System.out.println("\n***** Item not found. Returning to main menu. *****");
            }

          }
          break;
        case 5: // Display Items with Low Stock Warnings
          System.out.println("\n\n***** Low Stock Warnings *****");
          boolean lowStockFound = false;
          for (int i = 0; i < inventory.getItemCount(); i++) {
            Item item = inventory.getItem(i);
            if (item.isLowStock()) {
              item.displayItemDetails();
              lowStockFound = true;
            }
          }
          if (!lowStockFound) {
            System.out.println("\nNo items with low stock warnings. \n");
          }
          break;
        case 6: // Calculate Total Inventory Value
          double totalValue = 0;
          for (int i = 0; i < inventory.getItemCount(); i++) {
            Item item = inventory.getItem(i);
            totalValue += item.getTotalValue();
          }
          System.out.println("\nTotal Inventory Value: $" + String.format("%.2f", totalValue));
          break;
        default: // Invalid choice
          System.out.println("Invalid choice. Please choose again: ");
          choice = scanner.nextInt();
          continue;
      }

      System.out.println("\n\nWhat would you like to do next?");
      System.out.println("===========================================");
      System.out.println("1: Check inventory");
      System.out.println("2: Add item");
      System.out.println("3: Update item quantity");
      System.out.println("4: Search item");
      System.out.println("5: Display low stock warnings");
      System.out.println("6: Calculate total inventory value");
      System.out.println("0: Exit");
      System.out.println("===========================================");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
    }

    // Exit Message
    System.out.println("\n\n**************************************************************");
    System.out.println("Thank you for using the Inventory Management System. Goodbye!");
    System.out.println("**************************************************************\n\n");

    // close the scanner object
    scanner.close();

  }

}
