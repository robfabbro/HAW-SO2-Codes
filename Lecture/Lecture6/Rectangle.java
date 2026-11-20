package Lecture.Lecture6;

public class Rectangle extends Shape {

  private int width;
  private int height;

  public Rectangle(int x, int y, int width, int height) {
    super(x, y);
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  @Override 
  public double getArea() {
    return width * height;
  }

  @Override 
  public void rotateLeft() {
    System.out.println("Rotating Rectangle Left");
    int temp = this.width;
    this.width = this.height;
    this.height = temp;
  }
  
  @Override 
  public void rotateRight() {
    System.out.println("Rotating Rectangle Right");
    int temp = this.width;
    this.width = this.height;
    this.height = temp;
  }

  @Override
  public void resize(double factor) {
    this.width *= factor;
    this.height *= factor;
  }

}