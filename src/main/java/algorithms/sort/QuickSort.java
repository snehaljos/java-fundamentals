package algorithms.sort;

import java.util.Random;

/**
 * @author thepn
 */
public class QuickSort {

  private static final Random RANDOM = new Random();

  /**
   * Sorts the array using quick sort algorithm
   *
   * @param array
   * @param <T>
   */
  public static <T extends Comparable<T>> void quickSort(T[] array) {
    quickSort(array, 0, array.length - 1);
  }

  /**
   * Sorts the array using randomized quick sort algorithm
   *
   * @param array
   * @param <T>
   */
  public static <T extends Comparable<T>> void randomQuickSort(T[] array) {
    randomQuickSort(array, 0, array.length - 1);
  }

  private static <T extends Comparable<T>> void quickSort(T[] array, int start, int end) {
    int partition = partition(array, start, end);

    if (partition - 1 > start) {
      quickSort(array, start, partition - 1);
    }
    if (partition + 1 < end) {
      quickSort(array, partition + 1, end);
    }
  }

  private static <T extends Comparable<T>> void randomQuickSort(T[] array, int start, int end) {
    int partition = randomPartition(array, start, end);

    if (partition - 1 > start) {
      quickSort(array, start, partition - 1);
    }
    if (partition + 1 < end) {
      quickSort(array, partition + 1, end);
    }
  }

  /**
   * Puts the lower elements to the other side of the pivot element
   *
   * @param array
   * @param start
   * @param end
   * @param <T>
   * @return
   */
  private static <T extends Comparable<T>> int partition(T[] array, int start, int end) {
    T pivot = array[end];

    for (int i = start; i < end; i++) {
      if (array[i].compareTo(pivot) < 0) {
        T temp = array[start];
        array[start] = array[i];
        array[i] = temp;
        start++;
      }
    }

    T temp = array[start];
    array[start] = pivot;
    array[end] = temp;

    return start;
  }

  private static <T extends Comparable<T>> int randomPartition(T[] array, int start, int end) {
    int i = RANDOM.nextInt(end - start) + start;
    T temp = array[i];
    array[i] = array[end];
    array[end] = temp;
    return partition(array, start, end);
  }
}
