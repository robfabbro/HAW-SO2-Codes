package Lecture.Lecture5;

import java.util.ArrayList;

public class Shape {

  private int x;
  private int y;

  Shape(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double getArea() {
    return 0;
  }

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(0, 0, 10, 20);
    Circle circle = new Circle(5, 5, 10);
    Square square = new Square(2, 2, 5);

    System.out.println("\n\nCreated Three Shapes: ");
    System.out.println("Rectangle area: " + rectangle.getArea());
    System.out.println("Circle area: " + circle.getArea());
    System.out.println("Square area: " + square.getArea());
    
    
    // Store the shapes in an ArrayList of shapes
    ArrayList<Shape> shapes = new ArrayList<>();
    shapes.add(rectangle);
    shapes.add(circle);
    shapes.add(square);

    //Calculate the sum of all areas of all shapes
    double totalArea = 0;
    for (Shape shape : shapes) {
      totalArea += shape.getArea();
    }
    System.out.println("\n\nTotal area of all shapes: " + totalArea);

  }
  
}
