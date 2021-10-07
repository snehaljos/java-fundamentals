package algorithms.string;

import junit.framework.TestCase;

/**
 * @author thepn
 */
public class PalindromeTest extends TestCase {

  public void testPalindromes(){
    final PalindromeCheck check = new PalindromeCheck();

    assertTrue(check.isPalindrome("lagerregal"));
    assertTrue(check.isPalindrome("otto"));
    assertTrue(check.isPalindrome("anna"));
    assertTrue(check.isPalindrome("rentner"));
    assertTrue(check.isPalindrome("1221"));
    assertTrue(check.isPalindrome("@@§§&&§§@@"));
    assertTrue(check.isPalindrome("a"));
    assertTrue(check.isPalindrome("bb"));
    assertTrue(check.isPalindrome(""));
  }

  public void testNoPalindromes(){
    final PalindromeCheck check = new PalindromeCheck();

    assertFalse(check.isPalindrome("abcde"));
  }
}
