package task6;

public class Inventory {
  private Item[] items;
  private int itemCount;
  private static final int INITIAL_CAPACITY = 10;

  public Inventory() {
    items = new Item[INITIAL_CAPACITY];
    itemCount = 0;
  }

  //Getters and Setters
  public Item[] getItems() {
    return items;
  }

  public Item getItem(int index){
    if(index >= 0 && itemCount > 0 && index < itemCount){
      return items[index];
    } else {
      System.out.println("\n***** Sorry, this item does not exist. *****");
      return null;
    }
  }

  public int getItemCount() {
    return itemCount;
  }

  // Methods
  public void addItem(Item item) {
    if (itemCount >= items.length) {
      resizeArray();
    }
    items[itemCount++] = item;
  }

  private void resizeArray() {
    Item[] newItems = new Item[items.length * 2];
    System.arraycopy(items, 0, newItems, 0, items.length);
    items = newItems;
  }

  public Item findItemByID(int id) {
    for (int i = 0; i < itemCount; i++) {
      if (items[i].getItemID() == id) {
        return items[i];
      }
    }
    return null;
  }

  public Item findItemByName(String name) {
    for (int i = 0; i < itemCount; i++) {
      if (items[i].getName().equalsIgnoreCase(name)) {
        return items[i];
      }
    }
    return null;
  }

  public void generateReport() {

    System.out.println("\n\n===========================================");
    System.out.println("Inventory Report");
    System.out.println("===========================================");
    System.out.println("\nTotal Items: " + itemCount);

    
    if(itemCount > 0){
      System.out.printf("\n%-15s %-10s %-10s %-10s %-10s\n", "Name", "ID", "Quantity", "Price", "Total Value");
      System.out.print("------------------------------------------------------------\n");
      for (int i = 0; i < itemCount; i++) {
        Item item = getItem(i);
        // Print item details in a column readable format
        System.out.printf("%-15s %-10d %-10d $%-10.2f $%-10.2f\n", item.getName(), item.getItemID(), item.getQuantity(), item.getPrice(), item.getTotalValue());
      }
    } else {
      System.out.println("\nThe inventory is currently empty... \n");
    }
  }
}