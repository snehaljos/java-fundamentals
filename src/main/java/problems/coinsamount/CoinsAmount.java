package problems.coinsamount;

import java.util.ArrayList;
import java.util.List;

public interface CoinsAmount {

  /**
   * Calculate the minimal amount of coins needed to depict number using the given coin types.
   *
   * @param number    - The number we want to depict using the coins. Must be greater than zero.
   * @param coinTypes - List of given coin types. Must be sorted ascending
   * @return amount of coins needed
   */
  int calculateAmount(int number, List<Integer> coinTypes);

  /**
   * Filters the coin types that are greater than our value and removes them from the list
   *
   * @return a copy of our coin types list
   */
  default List<Integer> filterLargeCoinTypes(int value, List<Integer> coinTypes) {
    List<Integer> coinTypesCopy = new ArrayList<>(coinTypes);
    coinTypesCopy.removeIf(integer -> integer > value);
    return coinTypesCopy;
  }
}
