package task2;

public class GradeCalculator {

  public static void main(String[] args) {
  }


  public double calculateAverage(double[] grades) {
    double sum = 0;
    // uses a for loop (in the form of a forEach loop) to loop through the grades array
    for (double grade : grades) {
      sum += grade;
    }
    // calculates and returns the average grade
    return sum / grades.length;
  }

  public double findHighest(double[] grades) {
    // initializes the highest variable to the lowest possible value
    double highest = Integer.MIN_VALUE;
    // uses a for loop (in the form of a forEach loop) to loop through the grades array
    for (double grade : grades) {
      // updates the highest variable if the current grade is higher than the current highest value
      if (grade > highest) {
        highest = grade;
      }
    }
    return highest;
  }

  public double findLowest(double[] grades) {
    // initializes the lowest variable to the highest possible value
    double lowest = Integer.MAX_VALUE;
  // uses a for loop (in the form of a forEach loop) to loop through the grades array
    for (double grade : grades) {
      // updates the lowest variable if the current grade is lower than the current lowest value
      if (grade < lowest) {
        lowest = grade;
      }
    }
    return lowest;
  }

  public double countPassing(double[] grades) {
    double count = 0;
    // uses a for loop (in the form of a forEach loop) to loop through the grades array
    for (double grade : grades) {
      // increments the count variable if the current grade is greater than or equal to 60
      if (grade >= 60) {
        count++;
      }
    }
    return count;
  }

  public double[] deduplicatedGrades(double[] grades) {
    // creates a new array to store unique grades
    double[] uniqueGrades = new double[grades.length];
    int index = 0;
    // uses a for loop (in the form of a forEach loop) to loop through the grades array
    for (double grade : grades) {
      // checks if the current grade is already in the uniqueGrades array
      boolean isDuplicate = false;
      for (int i = 0; i < index; i++) {
        // if the current grade is found in the uniqueGrades array, set isDuplicate to true and break out of the loop
        if (uniqueGrades[i] == grade) {
          isDuplicate = true;
          break;
        }
      }
      // if the current grade is not a duplicate, add it to the uniqueGrades array and increment the index
      if (!isDuplicate) {
        uniqueGrades[index++] = grade;
      }
    }
    // returns a new array containing only the unique grades
    return java.util.Arrays.copyOf(uniqueGrades, index);
  }

}
