package task6;

public class Item {

  // Attributes
  private String name;
  private int itemID;
  private int quantity;
  private double price;
  private static int totalItems;

  // n Constructors
  public Item(String name, int itemID, int quantity, double price) {
    this.name = name;
    this.itemID = itemID;
    this.quantity = quantity;
    this.price = price;
    totalItems++;
  }

  // Getters and Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getItemID() {
    return itemID;
  }

  public void setItemID(int itemID) {
    this.itemID = itemID;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public static int getTotalItems() {
    return totalItems;
  }

  // Methods
  public double getTotalValue() {
    return quantity * price;
  }

  public boolean isLowStock() {
    return quantity < 5;
  }

  public void displayItemDetails() {
    // Display item details in a formatted manner
    System.out.println("\n***** Item Details *****");
    System.out.printf("Item ID: %d%n", itemID);
    System.out.printf("Name: %s%n", name);
    System.out.printf("Quantity: %d%n", quantity);
    System.out.printf("Price: $%.2f%n", price);
    System.out.printf("Total Value: $%.2f%n", getTotalValue());
  }
}
