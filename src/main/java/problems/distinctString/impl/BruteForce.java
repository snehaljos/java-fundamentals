package problems.distinctString.impl;

import problems.distinctString.DistinctString;

/**
 * @author Lorenz Nickel
 */
public class BruteForce implements DistinctString {

  @Override
  public boolean isDistinct(String s) {
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          return false;
        }
      }
    }
    return true;
  }
}
