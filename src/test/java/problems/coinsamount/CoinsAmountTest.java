package problems.coinsamount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import problems.coinsamount.impl.BruteForce;
import problems.coinsamount.impl.DynamicProgramming;

/**
 * @author thepn
 */
public class CoinsAmountTest extends TestCase {

  private static final List<Integer> coinTypes = new ArrayList<>(
      Arrays.asList(1, 2, 5, 10, 20, 50));
  private static final CoinsAmount[] implementations = new CoinsAmount[]{new BruteForce(),
      new DynamicProgramming()};

  public void testZero() {
    for (CoinsAmount impl : implementations) {
      assertEquals(0, impl.calculateAmount(0, coinTypes));
    }
  }

  public void testSolutions() {
    for (CoinsAmount impl : implementations) {
      System.out.println(impl.getClass().getSimpleName());
      assertEquals(1, impl.calculateAmount(1, coinTypes));
      assertEquals(1, impl.calculateAmount(2, coinTypes));
      assertEquals(1, impl.calculateAmount(5, coinTypes));
      assertEquals(2, impl.calculateAmount(6, coinTypes));
      assertEquals(3, impl.calculateAmount(8, coinTypes));
      assertEquals(2, impl.calculateAmount(3, coinTypes));
      assertEquals(3, impl.calculateAmount(13, coinTypes));
    }
  }

  public void testEdgeCases() {
    final List<Integer> coinTypes = new ArrayList<>(
        Arrays.asList(1, 6, 10));

    // check brute force on special coin types and number 12 (should be 6 + 6)
    assertEquals(2, implementations[0].calculateAmount(12, coinTypes));

    // check dynamic programming on special coin types and number 12 (should be 6 + 6)
    assertEquals(2, implementations[1].calculateAmount(12, coinTypes));
  }
}
