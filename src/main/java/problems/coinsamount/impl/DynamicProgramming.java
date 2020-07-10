package problems.coinsamount.impl;

import java.util.List;
import problems.coinsamount.CoinsAmount;

/**
 * @author thepn
 */
public class DynamicProgramming implements CoinsAmount {

  @Override
  public int calculateAmount(int number, List<Integer> coinTypesOriginal) {
    // filter coin types
    List<Integer> coinTypes = filterLargeCoinTypes(number, coinTypesOriginal);

    if (coinTypes.size() == 0) {
      return 0;
    }

    int[] solutions = new int[number + 1];
    solutions[0] = 0;

    for (int i = 1; i < number + 1; i++) {
      solutions[i] = findMax(solutions, i, coinTypes) + 1;
    }

    return solutions[number];
  }

  private int findSolution(int i, int[] solutions) {
    if (i < 0) {
      return Integer.MAX_VALUE;
    }

    return solutions[i];
  }

  private int findMax(int[] solutions, int i, List<Integer> coinTypes) {
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < coinTypes.size(); j++) {
      int value = findSolution(i - coinTypes.get(j), solutions);
      if (min > value) {
        min = value;
      }
    }

    return min;
  }
}
