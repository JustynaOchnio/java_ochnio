package pl.java_ochnio.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPoint() {
    Point a = new Point(30, 30);
    Point b = new Point(30, 30);
    Distance d = new Distance();
    Assert.assertEquals(d.distance(a, b), 0);
  }
}
