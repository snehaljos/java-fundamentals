package algorithms.math;

import java.util.stream.IntStream;

/**
 * FactorialTrailingZeros finds the amount trailing zeros for a given number n. If no trailing zeros
 * returns 0
 *
 * @author nujovich
 * @see <a href="http://mathworld.wolfram.com/Factorial.html"></a>
 */
public class FactorialTrailingZeros {

  /**
   * Calculates the number of trailing zeros.
   *
   * @param n
   * @return int number
   */
  public static int zeros(int n) {
    return IntStream.rangeClosed(1, (int) Math.round(Math.log(n) / Math.log(5)))
        .mapToObj(i -> (int) (n / Math.pow(5.0, i))).reduce(0, Integer::sum);
  }
}