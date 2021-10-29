package algorithms.math;

import junit.framework.TestCase;
import org.junit.Test;

public class FactorialTrailingZerosTest extends TestCase {

  @Test
  public void testZeros() throws Exception {
    assertEquals(FactorialTrailingZeros.zeros(0), 0);
    assertEquals(FactorialTrailingZeros.zeros(6), 1);
    assertEquals(FactorialTrailingZeros.zeros(14), 2);
  }

}
