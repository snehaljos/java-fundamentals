package algorithms.math;

/**
 * Simple implementation of the Euclidean algorithm
 *
 * @author josefdcunha, paultristanwagner
 * @see <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm">Euclidean algorithm (Wikipedia)</a>
 */
public class Euclidean {

  /**
   * Return the greatest common divisor by Euclidean algorithm (recursive)
   * @param a number
   * @param b number
   * @return greatest common divisor
   */
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  /**
   * Return the greatest common divisior by Euclidean algorithm (iterative)
   * @param a number
   * @param b number
   * @return greatest common divisor
   */
  public static int gcdIterative(int a, int b) {
    while(b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
