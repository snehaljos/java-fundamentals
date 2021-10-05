package algorithms.string;

/**
 * @author paultristanwagner
 * <p>
 * Calculates a common substring with maximum length of two strings <br>
 * More information: <a href="https://en.wikipedia.org/wiki/Longest_common_subsequence_problem">Wikipedia</a>
 * </p>
 */
public class LongestCommonSubString {

  private LongestCommonSubString() {

  }

  /**
   * Calculates a common substring with maximum length of two strings using an approach based on dynamic
   * programming <br>
   * Time and space compexity in O(|A|*|B|)
   *
   * @param a string
   * @param b string
   * @return a common substring with maximum length of the given strings
   */
  public static String calculate(String a, String b) {
    int[][] board = new int[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) {
      for (int k = 0; k <= b.length(); k++) {
        if (i == 0 || k == 0) {
          board[i][k] = 0;
        } else if (a.charAt(i - 1) == b.charAt(k - 1)) {
          board[i][k] = board[i - 1][k - 1] + 1;
        } else {
          board[i][k] = Math.max(board[i - 1][k], board[i][k - 1]);
        }
      }
    }

    return reconstructSubString(a, b, board);
  }

  /*
   * Reconstructs a common substring with maximum length based on the length board
   */
  private static String reconstructSubString(String a, String b, int[][] board) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = a.length();
    int k = b.length();

    while (i > 0 && k > 0) {
      if (a.charAt(i - 1) == b.charAt(k - 1) && board[i][k] == board[i - 1][k - 1] + 1) {
        stringBuilder.insert(0, a.charAt(i - 1));
        i--;
        k--;
      } else if (board[i - 1][k] == board[i][k]) {
        i--;
      } else {
        k--;
      }
    }
    return stringBuilder.toString();
  }

  /**
   * Calculates a common substring with maximum length of two strings using an approach based on recursion <br>
   *
   * @param a string
   * @param b string
   * @return a common substring with maximum length of the given strings
   */
  public static String calculateRecursive(String a, String b) {
    return calculateRecursive(a, b, 0, 0);
  }

  private static String calculateRecursive(String a, String b, int aOffset, int bOffset) {
    if (aOffset >= a.length() || bOffset >= b.length()) {
      return "";
    }

    if (a.charAt(aOffset) == b.charAt(bOffset)) {
      return a.charAt(aOffset) + calculateRecursive(a, b, aOffset + 1, bOffset + 1);
    }

    String res1 = calculateRecursive(a, b, aOffset + 1, bOffset);
    String res2 = calculateRecursive(a, b, aOffset, bOffset + 1);
    if (res2.length() >= res1.length()) {
      return res2;
    } else {
      return res1;
    }
  }
}
