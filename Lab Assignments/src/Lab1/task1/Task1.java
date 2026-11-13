package task1;

public class Task1 {
  public static void main(String[] args) throws Exception {
    // START

    // Greeting Message
    System.out.println("\nMoin!");

    // Create three Person objects
    Person person_1 = new Person();
    Person person_2 = new Person();
    Person person_3 = new Person();

    while (true) {

      // Read user input and store it in variable choice
      int choice = UserInput.askForWhichPerson();
      System.out.println("\nYou selected: " + choice);

      if (choice == 1 || choice == 2 || choice == 3) {// IF choice = 1 OR 2 OR 3 THEN
        // Ask and Read user input for first name, last name, day, month, year
        String firstName = UserInput.getPersonFirstName();
        String lastName = UserInput.getPersonLastName();
        int day = UserInput.getPersonChangeDay();
        int month = UserInput.getPersonChangeMonth();
        int year = UserInput.getPersonChangeYear();

        // Check if selected person can change name
        boolean canChangeName = false;
        if (choice == 1) {
          canChangeName = person_1.canChangeName(day, month, year);
        } else if (choice == 2) {
          canChangeName = person_2.canChangeName(day, month, year);
        } else if (choice == 3) {
          canChangeName = person_3.canChangeName(day, month, year);
        }

        // IF allowed THEN Change name of selected person and display their information
        if (canChangeName) {
          if (choice == 1) {
            person_1.changeName(firstName, lastName, day, month, year);
            person_1.displayInfo();
          } else if (choice == 2) {
            person_2.changeName(firstName, lastName, day, month, year);
            person_2.displayInfo();
          } else if (choice == 3) {
            person_3.changeName(firstName, lastName, day, month, year);
            person_3.displayInfo();
          }

        } else { // ELSE Display error: "Name cannot be changed within 3 years."
          System.out.println("\n----------------------------");
          System.out.println("\u001B[31mName cannot be changed \u001B[0m");
          System.out.println("\u001B[31mDate is within 3 years.\u001B[0m");
          System.out.println("----------------------------\n");
        }

      } else if (choice == 4) { // ELSE IF choice = 4 THEN Display information of all persons
        person_1.displayInfo();
        person_2.displayInfo();
        person_3.displayInfo();
      } else if (choice == 0) { // IF choice = 0 THEN end program
        System.out.println("Exiting program. Tschüss!\n");
        return;
      } else {// IF choice is invalid THEN end program with error message
        System.out.println("Invalid selection, exiting program. Auf Wiedersehen!\n");
        return;
      }
    }
  }
}
