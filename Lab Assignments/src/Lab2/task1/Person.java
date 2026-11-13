package task1;

public class Person {

  // Attributes
  private String firstName;
  private String lastName;

  private int changeDay;
  private int changeMonth;
  private int changeYear;

  private static int personCount = 0;

  // Constructor
  public Person() {
    firstName = "";
    lastName = "";
    changeDay = 0;
    changeMonth = 0;
    changeYear = 0;
    personCount++;
  }

  // Constructor with parameters
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    personCount++;
  }


  //Constructor with all parameters
  public Person(String firstName,
      String lastName,
      int changeDay,
      int changeMonth,
      int changeYear) {

    this.firstName = firstName;
    this.lastName = lastName;

    this.changeDay = changeDay;
    this.changeMonth = changeMonth;
    this.changeYear = changeYear;

    personCount++;
  }

  // Getters and Setters
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getChangeDay() {
    return changeDay;
  }

  public void setChangeDay(int changeDay) {
    if (changeDay < 1 || changeDay > 31) {
      System.out.print("Invalid Month Input: " + changeDay);
    } else {
      this.changeDay = changeDay;
    }
  }

  public int getChangeMonth() {
    return changeMonth;
  }

  public void setChangeMonth(int changeMonth) {
    if (changeMonth < 1 || changeMonth > 12) {
      System.out.print("Invalid Month Input: " + changeMonth);
    } else {
      this.changeMonth = changeMonth;
    }

  }

  public int getChangeYear() {
    return changeYear;
  }

  public void setChangeYear(int changeYear) {
    if (changeYear < 0) {
      System.out.print("Invalid Year Input: " + changeYear);
    } else {
      this.changeYear = changeYear;
    }
  }

  public static int getPersonCount() {
    return personCount;
  }

  // Checks whether 3 years have passed since last name change
  public boolean canChangeName(int day, int month, int year) {

    if ((year - getChangeYear()) > 3) {
      return true;
    } else if ((year - getChangeYear()) == 3) {
      if (month > getChangeMonth()) {
        return true;
      } else if (month == getChangeMonth()) {
        if (day >= getChangeDay()) {
          return true;
        }
      }
    }

    return false;
  }

  // Changes the name and stores the new change date
  public void changeName(String firstName,
      String lastName,
      int day,
      int month,
      int year) {

      setFirstName(firstName);
      setLastName(lastName);
      setChangeDay(day);
      setChangeMonth(month);
      setChangeYear(year);
  }

  // Displays all stored information
  public void displayInfo() {
    System.out.println("\nPerson Information:");
    System.out.println("---------------");
    System.out.println("First Name: " + this.firstName);
    System.out.println("Last Name: " + this.lastName);
    System.out.println("Date of Last Change: "
    + this.changeDay + "/"
    + this.changeMonth + "/"
    + this.changeYear);
    System.out.println("---------------\n");
  }
}