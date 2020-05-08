package datastructures.math;

import junit.framework.TestCase;

/**
 * @author Lorenz Nickel
 */
public class TupleTest extends TestCase {

  public void testImmutability() {
    final Tuple<Integer> tupleA = new Tuple<>(1, 2);
    assertEquals(tupleA.getA(), Integer.valueOf(1));
    assertEquals(tupleA.getB(), Integer.valueOf(2));
    final Tuple<Integer> tupleB = tupleA.withA(3);
    assertEquals(tupleA.getA(), Integer.valueOf(1));
    assertEquals(tupleB.getA(), Integer.valueOf(3));
  }

  public void testEquals() {
    final Tuple<Integer> tuple = new Tuple<>(1,2);
    assertEquals(tuple, new Tuple<>(1, 2));
    assertNotSame(null, tuple);
    assertNotSame(tuple, null);
    assertNotSame(1, tuple);
    assertNotSame(tuple, 1);
    assertNotSame(tuple, new Tuple<>(2, 1));
  }

  public void testHashCode() {
    assertEquals(new Tuple<>("a", "b"), new Tuple<>("a", "b"));
    assertNotSame(new Tuple<>("a", "b"), new Tuple<>("b", "a"));
  }

  public void testToString() {
    assertEquals(new Tuple<>(2.0f, 1.0f).toString(), "Tuple{a=2.0, b=1.0}");
  }

}
