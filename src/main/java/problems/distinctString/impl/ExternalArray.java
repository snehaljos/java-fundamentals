package problems.distinctString.impl;

import problems.distinctString.DistinctString;

/**
 * @author Lorenz Nickel
 */
public class ExternalArray implements DistinctString {

  @Override
  public boolean isDistinct(String s) {
    final int asciiOfZ = "z".charAt(0);
    final int asciiOfA = "a".charAt(0);
    boolean[] boolArr = new boolean[asciiOfZ - asciiOfA + 1];
    char[] arr = s.toCharArray();
    for (char c : arr) {
      if (boolArr[c - asciiOfA]) {
        return false;
      }
      boolArr[c - asciiOfA] = true;
    }
    return true;
  }
}
