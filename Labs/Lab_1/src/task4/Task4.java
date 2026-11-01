package task4;
import java.util.Scanner;

public class Task4 {

  public static void main(String[] args) {

    System.out.println("\nMoin!"); // prints a greeting message
    Scanner scanner = new Scanner(System.in); // initialises the scanner

    // Ask the user how many students they want to enter grades for
    System.out.print("Enter the number of students: ");
    int numStudents = scanner.nextInt();

    // Create an array to store the grades
    double[] grades = new double[numStudents];

    // Loops through each student in the array
    for (int i = 0; i < numStudents; i++) {
      // Prompt the user to enter each student’s grade (0-100)
      System.out.print("Enter grade for student " + (i + 1) + " (0-100): ");
      // And then reads the user's input
      grades[i] = scanner.nextDouble();
    }

    // Initialise the variables to count the statistics for the report
    double sumOfAllGrades = 0; // this variable is used to determine the average grade
    double highest = Double.MIN_VALUE; // sets highest to the highest possible Double value
    double lowest = Double.MAX_VALUE; // sets lowest to the lowest possible Double value
    int passedCount = 0;
    int failedCount = 0;

    // uses a for loop (in the form of a forEach loop) to loop through the grades array
    for (double grade : grades) {
      sumOfAllGrades += grade;

      // update the highest grade if the grade is higher than the current highest grade
      if (grade > highest) highest = grade;
      // update the lowest grade if the grade is lower than the current lowest grade
      if (grade < lowest) lowest = grade;

      // increment the pass/fail count based on the grade value
      if (grade >= 60) passedCount++;
      else failedCount++;
    }

    // calculate the average grade
    double average = (double) sumOfAllGrades / numStudents;

    // Print out the Grades for each student along with their letter grades
    System.out.println("\n=== Grade Report ===");
    for (int i = 0; i < numStudents; i++) {
      String letterGrade;
      if (grades[i] >= 90) letterGrade = "A";
      else if (grades[i] >= 80) letterGrade = "B";
      else if (grades[i] >= 70) letterGrade = "C";
      else if (grades[i] >= 60) letterGrade = "D";
      else letterGrade = "F";

      System.out.println("Student " + (i + 1) + ": " + grades[i] + " (" + letterGrade + ")");
    }

    // Display results of the statistics variables
    System.out.println("\n=== Statistics Summary ===");
    System.out.printf("Average Grade: ", average);
    System.out.println("Highest Grade: " + highest);
    System.out.println("Lowest Grade: " + lowest);
    System.out.println("Number of Students Passed: " + passedCount);
    System.out.println("Number of Students Failed: " + failedCount);


    scanner.close();
  }

}
