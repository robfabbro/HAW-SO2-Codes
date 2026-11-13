package task5;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Task5 {

  public static void main(String[] args) {
    // Create an array of Student objects with sample data
    Student[] students = {
        new Student(1, "Andrew", 90.5),
        new Student(2, "Belinda", 85.0),
        new Student(3, "Charlie", 92.0),
        new Student(1, "Andrew", 90.5), // Duplicate student
        new Student(5, "Eve", 88.0)
    };

    // Checking equality between students
    System.out.println("Equality Checking:");
    System.out.println("Student 1 equals Student 4: " + students[0].equals(students[3]));
    System.out.println("Student 1 equals Student 2: " + students[0].equals(students[1]));

    // Sort students by grade (natural ordering using the Double.compare method)
    Arrays.sort(students, (s1, s2) -> {
      return Double.compare(s1.getGrade(), s2.getGrade());
    });

    // Display sorted students by grade (natural ordering)
    System.out.println("\n\nStudents sorted by grade:");
    for (Student student : students) {
      System.out.printf("%-15s: %.1f%n", student.getName(), student.getGrade());
    }

    // Sort students by name using a custom comparator
    Arrays.sort(students, (s1, s2) -> {
      return s1.compareByName(s2);
    });

    // Display sorted students by name using a custom comparator
    System.out.println("\n\nStudents sorted by name:");
    for (Student student : students) {
      System.out.printf("%-15s: %.1f%n", student.getName(), student.getGrade());
    }

    // Find duplicate students and display them
    System.out.println("\n\n Finding Duplicate Students:");
    // Use a HashSet to track unique students based on their overridden hashCode method
    Set<Student> uniqueStudents = new HashSet<>();
    for (Student student : students) {
      // The add method returns false if the student is already in the set, indicating a duplicate
      if (!uniqueStudents.add(student)) {
        // so if the student is a duplicate, we print it out
        System.out.println("Found duplicate: " + student.getName() + ": " + student.getGrade());
      }
    }

    // Search for students by ID
    int searchID = 3;
    System.out.println("\n\nSearching for Student with ID " + searchID + ":");
    for (Student student : students) {
      if (student.getStudentID() == searchID) {
        System.out.println("Found: " + student.getName() + ": " + student.getGrade());
      }
    }

    // Search for students by Name
    String searchName = "Andrew";
    System.out.println("\n\nSearching for Students with name '" + searchName + "':");
    for (Student student : students) {
      if (student.getName().equals(searchName)) {
        System.out.println("Found: " + student.getName() + ": " + student.getGrade());
      }
    }

  }
}
