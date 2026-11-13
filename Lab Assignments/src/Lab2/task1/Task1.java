package task1;

public class Task1 {
  public static void main(String[] args) throws Exception {
    // START

    // Greeting Message
    System.out.println("\nMoin Moin!");

    // Create Persons array
    Person[] persons = new Person[3];

    // Create three Person objects
    persons[0] = new Person();
    persons[1] = new Person();
    persons[2] = new Person();

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
          canChangeName = persons[0].canChangeName(day, month, year);
        } else if (choice == 2) {
          canChangeName = persons[1].canChangeName(day, month, year);
        } else if (choice == 3) {
          canChangeName = persons[2].canChangeName(day, month, year);
        }

        // IF allowed THEN Change name of selected person and display their information
        if (canChangeName) {
          if (choice == 1) {
            persons[0].changeName(firstName, lastName, day, month, year);
            persons[0].displayInfo();
          } else if (choice == 2) {
            persons[1].changeName(firstName, lastName, day, month, year);
            persons[1].displayInfo();
          } else if (choice == 3) {
            persons[2].changeName(firstName, lastName, day, month, year);
            persons[2].displayInfo();
          }

        } else { // ELSE Display error: "Name cannot be changed within 3 years."
          System.out.println("\n----------------------------");
          System.out.println("\u001B[31mName cannot be changed \u001B[0m");
          System.out.println("\u001B[31mDate is within 3 years.\u001B[0m");
          System.out.println("----------------------------\n");
        }

      } else if (choice == 4) { // ELSE IF choice = 4 THEN Display information of all persons
        persons[0].displayInfo();
        persons[1].displayInfo();
        persons[2].displayInfo();
      } else if (choice == 5) {
        // ELSE IF choice = 5 THEN Display the number of persons created
        System.out.println("\nNumber of persons created: " + Person.getPersonCount());
      } else if (choice == 0) { // IF choice = 0 THEN end program
        System.out.println("Exiting program. Tschüss!\n");
        return;
      } else {// IF choice is invalid THEN end program with error message
        System.out.println("Invalid selection :" + choice + ", exiting program. Auf Wiedersehen!\n");
        return;
      }
    }
  }
}
