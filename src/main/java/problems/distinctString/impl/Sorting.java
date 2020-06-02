package problems.distinctString.impl;

import java.util.Arrays;
import problems.distinctString.DistinctString;

/**
 * @author Lorenz Nickel
 */
public class Sorting implements DistinctString {

  @Override
  public boolean isDistinct(String s) {
    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        return false;
      }
    }
    return true;
  }
}
