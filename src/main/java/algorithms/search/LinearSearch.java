package algorithms.search;

/**
 * Provides a simple implementation of linear-search based on an array. To use linear-search on an
 * array, instantiate an object of this class using {@link LinearSearch#LinearSearch(Comparable[])}
 * and then call {@link LinearSearch#searchFor(Comparable)} on this object. This method is
 * non-destructive, which means that you can call the method multiple times on the same array.
 *
 * @param <E> specifies the type of which the array used in the linear search is
 * @author Lorenz Nickel
 * @see <a href="https://en.wikipedia.org/wiki/Linear_search">Linear search algorithm
 * (Wikipedia)</a>
 */
public class LinearSearch<E extends Comparable<? super E>> {

  /**
   * Holds the array the linear-search is based on
   */
  private final E[] array;

  /**
   * @param array a possibly unsorted array in which should be searched, must not be null
   */
  public LinearSearch(final E[] array) {
    if (array == null) {
      throw new IllegalArgumentException("Parameter array must not be null");
    }
    this.array = array;
  }

  /**
   * @param target the value for which should be searched in {@link LinearSearch#array}, must not be
   *               null
   * @return index of {@code target} in {@link LinearSearch#array} (first occurrence), -1 if not
   * found
   */
  public int searchFor(final E target) {
    if (target == null) {
      throw new IllegalArgumentException("Parameter target most not be null");
    }
    for (int i = 0; i < this.array.length; i++) {
      if (target.compareTo(this.array[i]) == 0) {
        return i;
      }
    }
    return -1;
  }

}
