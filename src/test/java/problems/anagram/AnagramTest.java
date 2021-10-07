package problems.anagram;


import junit.framework.TestCase;
import problems.anagram.impl.ExternalMap;
import problems.anagram.impl.Sorting;

/**
 * @author Lorenz Nickel
 */
public class AnagramTest extends TestCase {

  private static final Anagram[] implementations = new Anagram[]{new Sorting(), new ExternalMap()};

  public void testSolutions() {
    for (Anagram implementation : implementations) {
      assertTrue(implementation.isAnagram("", ""));
      assertTrue(implementation.isAnagram("a", "a"));
      assertTrue(implementation.isAnagram("ba", "ab"));
      assertTrue(implementation.isAnagram("aba", "aab"));
      assertTrue(implementation.isAnagram("abcdabcd", "aabbccdd"));

      assertFalse(implementation.isAnagram("a", "b"));
      assertFalse(implementation.isAnagram("", "a"));
      assertFalse(implementation.isAnagram("a", ""));
      assertFalse(implementation.isAnagram("ab", "bb"));
      assertFalse(implementation.isAnagram("a", "ab"));
      assertFalse(implementation.isAnagram("ab", "a"));
      assertFalse(implementation.isAnagram("a", "aa"));
      assertFalse(implementation.isAnagram("aa", "a"));
      assertFalse(implementation.isAnagram("abcd", "abca"));
    }
  }

}
