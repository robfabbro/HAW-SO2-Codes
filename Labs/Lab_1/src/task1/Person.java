package task1;

public class Person {

  // Attributes
  private String first_name;
  private String last_name;

  private int change_day;
  private int change_month;
  private int change_year;

  // Constructor
  public Person() {
    first_name = "";
    last_name = "";
    change_day = 0;
    change_month = 0;
    change_year = 0;
  }

  // Checks whether 3 years have passed since last name change
  public boolean canChangeName(int day, int month, int year) {

    if ((year - change_year) > 3) {
      return true;
    } else if ((year - change_year) == 3) {
      if (month > change_month) {
        return true;
      } else if (month == change_month) {
        if (day >= change_day) {
          return true;
        }
      }
    }

    return false;
  }

  // Changes the name and stores the new change date
  public void changeName(String first_name,
      String last_name,
      int day,
      int month,
      int year) {

    this.first_name = first_name;
    this.last_name = last_name;

    this.change_day = day;
    this.change_month = month;
    this.change_year = year;
  }

  // Displays all stored information
  public void displayInfo() {
    System.out.println("\nPerson Information:");
    System.out.println("---------------");
    System.out.println("First Name: " + this.first_name);
    System.out.println("Last Name: " + this.last_name);
    System.out.println("Date of Last Change: "
    + this.change_day + "/"
    + this.change_month + "/"
    + this.change_year);
    System.out.println("---------------\n");
  }
}