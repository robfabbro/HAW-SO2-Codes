package task1;
import java.util.Scanner;

public class UserInput {

  public static void main(String[] args) {
    // Console input
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter something here: ");
    String input = scanner.nextLine();
    System.out.println("You entered \"" + input + "\"");

    // If a number is needed for case distinction (e.g., age of majority):
    System.out.print("Enter your age: ");
    int age = scanner.nextInt();
    if (age >= 18) {
      System.out.println("Of age.");
    } else {
      System.out.println("Not yet of age.");
    }

    scanner.close();
  }

  public static int askForWhichPerson() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nWhich Person wants to change their name?");
    System.out.println("1 = person_1");
    System.out.println("2 = person_2");
    System.out.println("3 = person_3");
    System.out.println("4 = display all persons");
    System.out.println("0 = exit program\n");

    int choice = scanner.nextInt();
    return choice;
  }
  public static String getPersonFirstName() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine();
    return firstName;
  }
  public static String getPersonLastName() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine();
    return lastName;
  }

  public static int getPersonChangeDay() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter day of name change (1-31): ");
    int day = scanner.nextInt();
    return day;
  }

  public static int getPersonChangeMonth() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter month of name change (1-12): ");
    int month = scanner.nextInt();
    return month;
  }

  public static int getPersonChangeYear() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter year of name change (e.g., 2024): ");
    int year = scanner.nextInt();
    return year;
  }
}