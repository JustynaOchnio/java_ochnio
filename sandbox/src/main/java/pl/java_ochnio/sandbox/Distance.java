package pl.java_ochnio.sandbox;

import static java.lang.Math.sqrt;

public class Distance {

  public double distance(Point A, Point B) {
    double temp = ((B.x - A.x) * (B.x - A.x) + (B.y - A.y) * (B.y - A.y));
    return sqrt(temp);
  }
}
