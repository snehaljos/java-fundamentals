package algorithms.math;

/**
 * PerfectPower is a class that checks if a number n can be expressed as n=m^k, where m is the root
 * and k is the exponent.
 *
 * @author nujovich
 * @see <a ref="https://en.wikipedia.org/wiki/Perfect_power"></a>
 */
public class PerfectPower {

  /**
   * @param n int, natural number
   * @return and array where the first element is the root and the second element is the exponent.
   * @apiNote if n has more than one tuple, the algorithm returns only the first one found.
   */
  public static int[] isPerfectPower(int n) {
    for (int i = 2; ; i++) {
      int root = (int) Math.round(Math.pow(n, 1.0 / i));
      if (root < 2) {
        return null;
      }
      if (Math.pow(root, i) == n) {
        return new int[]{root, i};
      }
    }
  }

}
