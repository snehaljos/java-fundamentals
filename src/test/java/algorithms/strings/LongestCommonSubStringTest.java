package algorithms.strings;

import algorithms.string.LongestCommonSubString;
import junit.framework.TestCase;

/**
 * @author paultristanwagner
 */
public class LongestCommonSubStringTest extends TestCase {

  public void testBasic() {
    assertEquals("Pommes", LongestCommonSubString.calculate("Pommes", "Pommes"));
    assertEquals("enn", LongestCommonSubString.calculate("mathemann", "ebenenspinne"));
    assertEquals("15756260", LongestCommonSubString.calculate(
        "00649152174546128609", "28135975267266905681"
    ));

    assertEquals("enn", LongestCommonSubString.calculateRecursive("mathemann", "ebenenspinne"));
  }
}
