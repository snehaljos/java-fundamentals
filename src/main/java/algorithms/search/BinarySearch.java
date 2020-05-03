package algorithms.search;

/**
 * Provides a simple implementation of binary-search based on a sorted array. To use binary-search
 * on an array, instantiate an object of this class using {@link BinarySearch#BinarySearch(Comparable[])}
 * and then call {@link BinarySearch#searchFor(Comparable)} on this object. This method is
 * non-destructive, which means that you can call the method multiple times on the same array.
 *
 * @param <E> specifies the type of which the array used in the binary search is
 * @author Lorenz Nickel
 * @see <a href="https://en.wikipedia.org/wiki/Binary_search_algorithm">Binary search algorithm
 * (Wikipedia)</a>
 */
public class BinarySearch<E extends Comparable<? super E>> {

  /**
   * This is used to determine if in case the {@code span} within a binary-search is even the left
   * or the right index should be used as {@code middleIndex}
   */
  private static final boolean PREFER_RIGHT = false;

  /**
   * Holds the array the binary-search is based on
   */
  private final E[] array;

  /**
   * @param array a sorted array in which should be searched, must not be null
   */
  public BinarySearch(final E[] array) {
    if (array == null) {
      throw new IllegalArgumentException("Parameter array must not be null");
    }
    this.array = array;
  }

  /**
   * @param target the value for which should be searched in {@link BinarySearch#array}, must not be
   *               null
   * @return index of {@code target} in {@link BinarySearch#array}, -1 if not found
   */
  public int searchFor(final E target) {
    if (target == null) {
      throw new IllegalArgumentException("Parameter target most not be null");
    }
    int leftBoundary = 0;
    int rightBoundary = array.length - 1;

    while (leftBoundary <= rightBoundary) {
      int span = rightBoundary - leftBoundary;
      if (PREFER_RIGHT && span % 2 == 0) {
        span++;
      }
      final int middleIndex = leftBoundary + (span / 2);
      switch (Integer.signum(target.compareTo(array[middleIndex]))) {
        case 0:
          return middleIndex;
        case 1:
          leftBoundary = middleIndex + 1;
          break;
        case -1:
          rightBoundary = middleIndex - 1;
          break;
        default:
          //do nothing - this should not happen
      }
    }
    return -1;
  }

}
