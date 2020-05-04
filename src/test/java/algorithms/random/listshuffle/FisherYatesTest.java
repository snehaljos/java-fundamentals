package algorithms.random.listshuffle;

import algorithms.random.ListShuffle;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

/**
 * @author thepn
 */
public class FisherYatesTest extends TestCase {

  public void testSize() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    ListShuffle.fisherYatesShuffle(list);
    assertEquals(5, list.size());
  }

  public void testSum() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    ListShuffle.fisherYatesShuffle(list);
    int sum = 0;

    for (Integer integer : list) {
      sum += integer;
    }

    assertEquals(15, sum);
  }
}
