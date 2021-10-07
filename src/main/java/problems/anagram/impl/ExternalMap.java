package problems.anagram.impl;

import java.util.HashMap;
import java.util.Map;
import problems.anagram.Anagram;

/**
 * @author Lorenz Nickel
 */
public class ExternalMap implements Anagram {

  @Override
  public boolean isAnagram(String s1, String s2) {
    Map<Character, Integer> occurrences = new HashMap<>();
    char[] s1Arr = s1.toCharArray();
    for (char c : s1Arr) {
      if (occurrences.containsKey(c)) {
        occurrences.put(c, occurrences.get(c) + 1);
      } else {
        occurrences.put(c, 1);
      }
    }
    char[] s2Arr = s2.toCharArray();
    for (char c : s2Arr) {
      int available = occurrences.getOrDefault(c, 0);
      if (available == 0) {
        return false;
      }
      if (available == 1) {
        occurrences.remove(c);
      } else {
        occurrences.put(c, available - 1);
      }
    }
    return occurrences.isEmpty();
  }

}
