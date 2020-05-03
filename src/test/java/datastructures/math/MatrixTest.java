package datastructures.math;

import junit.framework.TestCase;

/**
 * @author Lorenz Nickel
 */
public class MatrixTest extends TestCase {

  private static final int[][] base = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

  public void testDimensions() {
    final Matrix matrix = new Matrix(base);
    assertEquals(matrix.getMatrixDimensions(), new Tuple<>(3, 4));
    matrix.transpose();
    assertEquals(matrix.getMatrixDimensions(), new Tuple<>(4, 3));
  }

  public void testTransposeInversion() {
    final Matrix matrix = new Matrix(base);
    matrix.transpose();
    matrix.transpose();
    assertEquals(matrix, new Matrix(base));
  }

  public void testAdd() {
    final Matrix matrix = new Matrix(base);
    matrix.add(matrix);
    assertEquals(matrix, new Matrix(new int[][]{{2, 4, 6}, {2, 4, 6}, {2, 4, 6}, {2, 4, 6}}));
  }

  public void testMultiply() {
    final Matrix matrixA = new Matrix(base);
    final Matrix matrixB = new Matrix(base);
    matrixA.transpose();
    matrixA.multiply(matrixB);
    assertEquals(matrixA, new Matrix(new int[][]{{4, 8, 12}, {8, 16, 24}, {12, 24, 36}}));
  }

  public void testEmptyMatrix() {
    int[][] emptyBase = new int[0][];
    Matrix matrixA = new Matrix(emptyBase);
    Matrix matrixB = new Matrix(emptyBase);
    assertEquals(matrixA, matrixB);
    matrixA.transpose();
    assertEquals(matrixA, matrixB);
    matrixA.add(matrixB);
    assertEquals(matrixA, matrixB);
    matrixA.multiply(matrixB);
    assertEquals(matrixA, matrixB);
    assertEquals(matrixA, matrixA.clone());
  }

  public void testClone() {
    final Matrix matrixA = new Matrix(base);
    final Matrix matrixB = matrixA.clone();
    assertEquals(matrixA, matrixB);
    matrixA.add(matrixA);
    assertNotSame(matrixA, matrixB);
    matrixB.add(matrixB);
    assertEquals(matrixA, matrixB);
  }

}
