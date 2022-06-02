package pl.java_ochnio.sandbox;

import static java.lang.Math.sqrt;

public class Point {
  public double x;
  public double y;

  public static void main(String[] args) {
    Point A = new Point();
    A.x = 50;
    A.y = 50;

    Point B = new Point();
    B.x = 10;
    B.y = 100;
    
    System.out.println("Współrzędne punktu A wynoszą: " + A.x + " , "+ A.y);
    System.out.println("Współrzędne punktu B wynoszą: " + B.x + " , "+ B.y);

    Distance d = new Distance();
    System.out.println("Odległość między punktem A i punktem B wynosi " + d.distance(A, B));

  }



}
