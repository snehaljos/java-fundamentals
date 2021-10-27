package problems.longestconsecstring;

import junit.framework.TestCase;
import org.junit.Test;
import problems.longestconsecstring.impl.LongestConsecString;

public class LongestConsecStringTest extends TestCase {

  private static void testing(String actual, String expected) {
    assertEquals(expected, actual);
  }

  @Test
  public void test() {
    testing(LongestConsecString
        .longestConsecString(
            new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"},
            2), "abigailtheta");
    testing(LongestConsecString.longestConsecString(
        new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb",
            "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
    testing(LongestConsecString.longestConsecString(
        new String[]{}, 3), "");
    testing(LongestConsecString.longestConsecString(
            new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv",
                "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2),
        "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
    testing(LongestConsecString.longestConsecString(
            new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2),
        "wlwsasphmxxowiaxujylentrklctozmymu");
    testing(LongestConsecString.longestConsecString(
        new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
    testing(LongestConsecString.longestConsecString(
            new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3),
        "ixoyx3452zzzzzzzzzzzz");
    testing(LongestConsecString.longestConsecString(
        new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
    testing(LongestConsecString.longestConsecString(
        new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
  }
}
