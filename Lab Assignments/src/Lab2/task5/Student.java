package task5;

public class Student {

  private int studentID;
  private String name;
  private double grade;

  public Student(int studentID, String name, double grade) {
    this.studentID = studentID;
    this.name = name;
    this.grade = grade;
  }

  // Getters for the private fields
  public int getStudentID() {
    return studentID;
  }

  public String getName() {
    return name;
  }

  public double getGrade() {
    return grade;
  }

  //override methods for equals and hashCode
  @Override
  public boolean equals(Object obj) {
    // Check if the object is compared with itself
    if (this == obj) {
      return true;
    }
    // Check if the object is an instance of Student
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    // Typecast obj to Student so that we can compare data members
    Student other = (Student) obj;
    // Compare studentID, name, and grade for equality
    return this.compareByID(other) == 0 && this.compareByName(other) == 0 && this.compareByGrade(other) == 0;
  }

  @Override
  public int hashCode() {
    // Use a prime number to calculate hash code based on studentID, name, and grade
    // the 31 multiplier is used again to reduce the chance of collisions in the hash code calculation

    // first calculate the hash code for studentID
    int result = Integer.hashCode(studentID);
    // secondly, we calculate the hash code for the name field. If the name is not null, we use its hashCode method; otherwise, we use 0.
    result = 31 * result + (name != null ? name.hashCode() : 0);
    // finally, we calculate the hash code for the grade field using Double.hashCode method
    result = 31 * result + Double.hashCode(grade);
    return result;
  } 

  // Comparison methods for different criteria, using the inbuilt compare methods for int, String, and double types
  // returns a negative integer, if the data is less than the compared data,
  // zero, if this data is equal to the compared data,
  // or a positive integer if this data is greater than the compared data
  public int compareByID(Student other) {
    return Integer.compare(this.studentID, other.studentID); 
  }

  public int compareByName(Student other) {
    return this.name.compareTo(other.name);
  }

  public int compareByGrade(Student other) {
    return Double.compare(this.grade, other.grade);
  }





}
