package task2;

import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) {
    System.out.println("\nMoin!"); // prints a greeting message
    Scanner scanner = new Scanner(System.in); // initialises the scanner
    GradeCalculator gradeCalculator = new GradeCalculator(); // creates an instance of the GradeCalculator class

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

    // Calculate the average grade
    double average = gradeCalculator.calculateAverage(grades);
    double highest = gradeCalculator.findHighest(grades);
    double lowest = gradeCalculator.findLowest(grades);
    double passedCount = gradeCalculator.countPassing(grades);
    double failedCount = numStudents - passedCount;
    double[] deduplicatedGrades = gradeCalculator.deduplicatedGrades(grades);

    // Display results of the statistics variables
    System.out.println("\n=== Statistics Summary ===");
    System.out.println("Average Grade: " + average);
    System.out.println("Highest Grade: " + highest);
    System.out.println("Lowest Grade: " + lowest);
    System.out.println("Number of Students Passed: " + passedCount);
    System.out.println("Number of Students Failed: " + failedCount);
    System.out.println("Unique Grades: " + deduplicatedGrades.length);
    System.out.print("[");
    for (int i = 0; i < deduplicatedGrades.length; i++) {
      if (i < deduplicatedGrades.length - 1) {
        System.out.print(deduplicatedGrades[i] + ", ");
      } else {
        System.out.print(deduplicatedGrades[i]);
      }
    }
    System.out.print("]");

    scanner.close();
  }

}
