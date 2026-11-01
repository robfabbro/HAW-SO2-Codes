public class Circle {
  double x;
  double y;
  double radius;

  public Circle() {
    this.x = 0;
    this.y = 0;
    this.radius = 1;
  }

  public Circle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public Circle(double radius) {
    //this(0, 0, radius);
    this.x = 0;
    this.y = 0;
    this.radius = radius;
  }

  public Circle(Circle other) {
    //this(other.x, other.y, other.radius);
    this.x = other.x;
    this.y = other.y;
    this.radius = other.radius;
  }
}
