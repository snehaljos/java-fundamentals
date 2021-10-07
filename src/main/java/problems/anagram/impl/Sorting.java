package problems.anagram.impl;

import java.util.Arrays;
import problems.anagram.Anagram;

/**
 * @author Lorenz Nickel
 */
public class Sorting implements Anagram {

  @Override
  public boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    char[] s1Sorted = stringToSortedCharArray(s1);
    char[] s2Sorted = stringToSortedCharArray(s2);
    for (int i = 0; i < s1Sorted.length; i++) {
      if (s1Sorted[i] != s2Sorted[i]) {
        return false;
      }
    }
    return true;
  }

  private char[] stringToSortedCharArray(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return chars;
  }
}
