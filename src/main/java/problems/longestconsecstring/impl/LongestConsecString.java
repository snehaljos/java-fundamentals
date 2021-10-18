package problems.longestconsecstring.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author nujovich
 * Check README.md for guidelines
 *
 */
public class LongestConsecString {

  public static String longestConsecString(String[] strarr, int k) {
    if (k <= 0) {
      return "";
    }
    return IntStream.rangeClosed(0, strarr.length - k)
        .mapToObj(i -> Arrays.stream(strarr, i, i + k)
            .collect(Collectors.joining())).max(Comparator.comparingInt(String::length)).orElse("");
  }

}
