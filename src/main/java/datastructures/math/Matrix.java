package datastructures.math;

import java.util.Arrays;

/**
 * Matrix of ints represented internally by two-dimensional array
 *
 * @author Lorenz Nickel
 */
public class Matrix {

  private int[][] array;

  /**
   * @param array the array on which the matrix should be based on, must not be null and must be
   *              rectangular
   */
  public Matrix(final int[][] array) {
    if (array == null) {
      throw new IllegalArgumentException("Parameter array must not be null");
    }
    if (!isValidMatrix(array)) {
      throw new IllegalArgumentException("Parameter array does not represent a valid matrix");
    }
    this.array = copyTwoDimensionalArray(array);
  }

  /**
   * @return a clone of the matrix which can be edited without editing the original matrix
   */
  public Matrix clone() {
    return new Matrix(copyTwoDimensionalArray(this.array));
  }

  /**
   * @return an independent array which is represented by the matrix
   */
  public int[][] getAsArray() {
    return this.clone().array;
  }

  /**
   * @param array which should be checked, must not be null
   * @return if the given array is rectangular
   */
  public static boolean isValidMatrix(final int[][] array) {
    if (array == null) {
      throw new IllegalArgumentException("Parameter array must not be null");
    }
    if (array.length == 0) {
      return true;
    }
    for (int i = 1; i < array.length; i++) {
      if (array[0].length != array[1].length) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param array which should be copied, must not be null
   * @return an independent clone of the array
   */
  private static int[][] copyTwoDimensionalArray(final int[][] array) {
    if (array == null) {
      throw new IllegalArgumentException("Parameter array must not be null");
    }
    final int[][] copy = new int[array.length][];
    for (int i = 0; i < array.length; i++) {
      copy[i] = Arrays.copyOf(array[i], array[i].length);
    }
    return copy;
  }

  /**
   * @return a {@link Tuple} in which {@link Tuple#getA()} represents the height of the matrix
   * {@link Tuple#getB()} its width
   */
  public Tuple<Integer> getMatrixDimensions() {
    if (this.array.length == 0) {
      return new Tuple<>(0, 0);
    }
    return new Tuple<>(array[0].length, array.length);
  }

  /**
   * @param coordinates a {@link Tuple} which represents the coordinates, in which {@link
   *                    Tuple#getA()} is the vertical index and {@link Tuple#getB()} the horizontal
   *                    (both start at 0)
   * @return the value of the matrix at the specified coordinates
   */
  public int getValueAtCoordinates(final Tuple<Integer> coordinates) {
    if (coordinates == null) {
      throw new IllegalArgumentException("Argument coordinates must not be null");
    }
    Tuple<Integer> dimensions = this.getMatrixDimensions();
    if (coordinates.getA() >= dimensions.getA() || coordinates.getB() >= dimensions.getB()
        || coordinates.getA() < 0 || coordinates.getB() < 0) {
      throw new IllegalArgumentException("Argument coordinates " + coordinates
          + " requests position out of the dimensions of the actual matrix " + dimensions
      );
    }
    return this.array[coordinates.getB()][coordinates.getA()];
  }

  /**
   * @param matrix which should be added to this matrix, must have the same dimensions
   */
  public void add(Matrix matrix) {
    if (matrix == null) {
      throw new IllegalArgumentException("Argument matrix must not be null");
    }
    if (!this.getMatrixDimensions().equals(matrix.getMatrixDimensions())) {
      throw new IllegalArgumentException(
          "Argument matrix with dimensions " + matrix.getMatrixDimensions()
              + " does not match the dimensions of this matrix " + this.getMatrixDimensions());
    }
    if (this.array.length == 0) {
      return;
    }
    for (int m = 0; m < this.array[0].length; m++) {
      for (int n = 0; n < this.array.length; n++) {
        this.array[n][m] += matrix.array[n][m];
      }
    }
  }

  /**
   * Transposes the matrix
   */
  public void transpose() {
    if (this.array.length == 0) {
      return;
    }
    int[][] result = new int[this.array[0].length][this.array.length];

    for (int m = 0; m < this.array[0].length; m++) {
      for (int n = 0; n < this.array.length; n++) {
        result[m][n] = this.array[n][m];
      }
    }
    this.array = result;
  }

  /**
   * @param matrix which should be multiplied to this matrix. The width of the base-matrix has to
   *               match the height of the matrix specified in this parameter
   */
  public void multiply(Matrix matrix) {
    if (matrix == null) {
      throw new IllegalArgumentException("Argument matrix must not be null");
    }
    if (!this.getMatrixDimensions().getB().equals(matrix.getMatrixDimensions().getA())) {
      throw new IllegalArgumentException(
          "Argument matrix with dimensions " + matrix.getMatrixDimensions()
              + " must not be multiplied with this matrix with dimensions " + this
              .getMatrixDimensions());
    }
    if (this.array.length == 0) {
      return;
    }
    int[][] result = new int[this.array.length][matrix.array[0].length];

    for (int m = 0; m < this.array.length; m++) {
      for (int n = 0; n < matrix.array[0].length; n++) {
        for (int i = 0; i < this.array[0].length; i++) {
          result[m][n] += this.array[m][i] * matrix.array[i][n];
        }
      }
    }
    this.array = result;
  }

  /**
   * @param scalar which the matrix should be scaled with
   */
  public void multiply(int scalar) {
    if (this.array.length == 0) {
      return;
    }
    for (int m = 0; m < this.array[0].length; m++) {
      for (int n = 0; n < this.array.length; n++) {
        this.array[n][m] *= scalar;
      }
    }
  }

  @Override
  public String toString() {
    return "Matrix{" +
        "array=" + Arrays.deepToString(array) +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Matrix matrix = (Matrix) o;
    return Arrays.deepEquals(array, matrix.array);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(array);
  }
}
