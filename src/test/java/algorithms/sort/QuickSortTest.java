package algorithms.sort;

import junit.framework.TestCase;

/**
 * @author thepn
 */
public class QuickSortTest extends TestCase {

  public void testQuickSort() {
    Short[] array = new Short[]{3, 2, 5, 4, 1};

    QuickSort.quickSort(array);

    for (int i = 0; i < 5; i++) {
      assertEquals(i + 1, (short) array[i]);
    }
  }

  public void testRandomQuickSort() {
    System.out.println("#1");
    Short[] array = new Short[]{3, 2, 5, 4, 1};

    QuickSort.randomQuickSort(array);

    for (int i = 0; i < 5; i++) {
      assertEquals(i + 1, (short) array[i]);
    }
  }

}
