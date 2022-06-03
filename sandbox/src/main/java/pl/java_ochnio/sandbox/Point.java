package pl.java_ochnio.sandbox;

import static java.lang.Math.sqrt;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static void main(String[] args) {
    Point A = new Point(20, 10);
    Point B = new Point(20, 20);


    System.out.println("Współrzędne punktu A wynoszą: " + A.x + " , " + A.y);
    System.out.println("Współrzędne punktu B wynoszą: " + B.x + " , " + B.y);

    Distance d = new Distance();
    System.out.println("Odległość między punktem A i punktem B wynosi " + d.distance(A, B));

  }


}
