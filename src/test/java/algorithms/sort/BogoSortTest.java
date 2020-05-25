package algorithms.sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import junit.framework.TestCase;

/**
 * @author thepn
 */
public class BogoSortTest extends TestCase {

  public void testBogoSort() {
    final Short[] arrayA = new Short[]{3, 2, 5, 4, 1};

    BogoSort.bogoSort(arrayA);

    for (int i = 0; i < 5; i++) {
      assertEquals(i + 1, (short) arrayA[i]);
    }

    final Short[] arrayB = new Short[]{1, 3, 5, 3, 5, 3, 2, 3, 8, -1, -12};
    final Short[] arrayC = Arrays.copyOf(arrayB, arrayB.length);

    BogoSort.bogoSort(arrayB);
    InsertionSort.insertionSort(arrayC);
    assertArrayEquals(arrayB, arrayC);
  }

  public void testBogoSortEdgeCases() {
    final String[] arrayA = new String[0];
    BogoSort.bogoSort(arrayA);

    final Float[] arrayB = new Float[]{1.0f};
    BogoSort.bogoSort(arrayB);
  }

}
