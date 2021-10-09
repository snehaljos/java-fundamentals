package problems.disctinctstring;

import junit.framework.TestCase;
import problems.distinctString.DistinctString;
import problems.distinctString.impl.BruteForce;
import problems.distinctString.impl.ExternalArray;
import problems.distinctString.impl.Sorting;

/**
 * @author Lorenz Nickel
 */
public class DistinctStringTest extends TestCase {

  private static final DistinctString[] implementations = new DistinctString[]{new BruteForce(),
      new Sorting(), new ExternalArray()};
  private static final String allCharactersString = "abcdefghijklmnopqrstuvwxyz";

  public void testEmptyString() {
    for (DistinctString impl : implementations) {
      assertTrue(impl.isDistinct(""));
    }
  }

  public void testSolutions() {
    for (DistinctString impl : implementations) {
      assertTrue(impl.isDistinct("a"));
      assertTrue(impl.isDistinct(allCharactersString));
      assertFalse(impl.isDistinct(allCharactersString + "a"));
      assertFalse(impl.isDistinct(allCharactersString + allCharactersString));
    }
  }


}
