package algorithms.string;

/**
 * @author thepn
 * <p>
 * Palindrome-Checker. Checks if a string is equal to the reverse string. Examples for palindromes:
 * lagerregal, rentner, otto, anna... More information: <a href="https://en.wikipedia.org/wiki/Palindrome">Wikipedia</a>
 * </p>
 */
public class PalindromeCheck {

  /**
   * Checks if a string is a palindrome. The algorithm runs in O(n).
   * @param input
   * @return true if input string is a palindrome
   */
  public boolean isPalindrome(String input) {
    final int length = input.length();

    for (int i = 0; i < length / 2; i++) {
      if (input.charAt(i) != input.charAt(length - (i + 1))) {
        return false;
      }
    }

    return true;
  }

}
