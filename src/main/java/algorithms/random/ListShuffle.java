package algorithms.random;

import java.util.List;
import java.util.Random;

/**
 * @author thepn
 */
public class ListShuffle {

  private ListShuffle() {

  }

  /**
   * Using the fisher yates algorithm to shuffle a list
   *
   * @param <T> The type of the list
   * @param list The list that should be shuffled
   */
  public static <T> void fisherYatesShuffle(final List<T> list) {
    final Random random = new Random();

    T temp;
    int size = list.size();

    for (int i = 0; i < size; i++) {
      int index = i + (int) (random.nextDouble() * (size - i));
      temp = list.get(index);
      list.set(index, list.get(i));
      list.set(i, temp);
    }

  }

  /**
   * Using the fisher yates algorithm to shuffle a list
   *
   * @param <T> </T> The type of the list
   * @param list The array that should be shuffled
   */
  public static <T> void fisherYatesShuffle(T[] list) {
    final Random random = new Random();

    T temp;
    int size = list.length;

    for (int i = 0; i < size; i++) {
      int index = i + (int) (random.nextDouble() * (size - i));
      temp = list[index];
      list[index] = list[i];
      list[i] = temp;
    }
  }
}
