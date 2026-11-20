package Lecture.Lecture6;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Shape implements Transformble, Comparable<Shape> {

  private int x;
  private int y;

  Shape(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public abstract double getArea();

  @Override
  public void move(double dx, double dy) {
    this.x += dx;
    this.y += dy;
  }

    @Override 
  public void rotateLeft() {
    System.out.println("Rotating Shape Left");
  }
  
  @Override 
  public void rotateRight() {
    System.out.println("Rotating Shape Right");
  }

  @Override
  public int compareTo(Shape other) {
    return Double.compare(this.getArea(), other.getArea());
  }

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(0, 0, 10, 20);
    Circle circle = new Circle(5, 5, 10);
    Square square = new Square(2, 2, 5);
    
    System.out.println("\n\nCreated Three Shapes For Lecture 6: ");
    System.out.println("Rectangle area: " + rectangle.getArea());
    System.out.println("Circle area: " + circle.getArea());
    System.out.println("Square area: " + square.getArea());
    
    
    // Store the shapes in an ArrayList of shapes
    ArrayList<Shape> shapes = new ArrayList<>();
    shapes.add(rectangle);
    shapes.add(circle);
    shapes.add(square);

    //Sort the shapes by area
    Collections.sort(shapes);

    //print the sorted shapes
    System.out.println("\n\nSorted Shapes by Area: ");
    for (Shape shape : shapes) {
      System.out.println(shape.getClass().getSimpleName() + " area: " + shape.getArea());
    } 

    //Calculate the sum of all areas of all shapes
    double totalArea = 0;
    for (Shape shape : shapes) {
      totalArea += shape.getArea();
    }
    System.out.println("\n\nTotal area of all shapes: " + totalArea);

    Transformble transformableRectangle = rectangle;
    Shape shapeRectangle = rectangle;

    System.out.println("\n\nRotating transformableRectangle: ");
    transformableRectangle.rotateLeft();
    transformableRectangle.rotateRight();
    System.out.println("\n\nRotating shapeRectangle: ");
    shapeRectangle.rotateLeft();
    shapeRectangle.rotateRight();
    System.out.println("\n\nRotating Rectangle: ");
    rectangle.rotateLeft();
    rectangle.rotateRight();

  }
  
}
