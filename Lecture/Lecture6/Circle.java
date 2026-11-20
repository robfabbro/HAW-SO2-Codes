package Lecture.Lecture6;

public class Circle extends Shape {

  private int radius;

  public Circle(int x, int y, int radius) {
    super(x, y);
    this.radius = radius;
  }

  public int getRadius() {
    return this.radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override 
  public void resize(double factor) {
    this.radius *= factor;
  }

}
