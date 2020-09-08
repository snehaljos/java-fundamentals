package datastructures.heap;

import java.util.Arrays;
import junit.framework.TestCase;

/**
 * Created by thepn on 16.07.2020.
 */
public class MaxArrayHeapTest extends TestCase {

  public void testParent() {
    final MaxArrayHeap<Integer> maxArrayHeap = new MaxArrayHeap<Integer>(
        Arrays.asList(5, 2, 6, 32, 4, 6, 8, 3, 1));

    assertEquals(0, maxArrayHeap.parentIndex(1));
    assertEquals(0, maxArrayHeap.parentIndex(2));
    assertEquals(1, maxArrayHeap.parentIndex(4));
    assertEquals(2, maxArrayHeap.parentIndex(5));
    assertEquals(2, maxArrayHeap.parentIndex(6));

    int result = maxArrayHeap.parent(1);
    assertEquals(5, result);

    result = maxArrayHeap.parent(3);
    assertEquals(2, result);

    try {
      maxArrayHeap.parentIndex(0);
      fail();
    } catch (IllegalArgumentException e) {
    }

    try {
      maxArrayHeap.parent(0);
      fail();
    } catch (IllegalArgumentException e) {
    }

    try {
      maxArrayHeap.parentIndex(9);
      fail();
    } catch (IndexOutOfBoundsException e) {
    }

    try {
      maxArrayHeap.parent(9);
      fail();
    } catch (IndexOutOfBoundsException e) {
    }
  }

  public void testLeftChild() {
    final MaxArrayHeap<Integer> maxArrayHeap = new MaxArrayHeap<Integer>(
        Arrays.asList(5, 2, 6, 32, 4, 6, 8, 3, 1));

    assertEquals(1, maxArrayHeap.leftChildIndex(0));
    assertEquals(3, maxArrayHeap.leftChildIndex(1));
    assertEquals(7, maxArrayHeap.leftChildIndex(3));

    int result = maxArrayHeap.leftChild(0);

    assertEquals(2, result);

    result = maxArrayHeap.leftChild(1);
    assertEquals(32, result);

    result = maxArrayHeap.leftChild(3);
    assertEquals(3, result);

    try {
      maxArrayHeap.leftChild(8);
      fail();
    } catch (IndexOutOfBoundsException e) {
    }
  }

  public void testRightChild() {
    final MaxArrayHeap<Integer> maxArrayHeap = new MaxArrayHeap<Integer>(
        Arrays.asList(5, 2, 6, 32, 4, 6, 8, 3, 1));

    assertEquals(2, maxArrayHeap.rightChildIndex(0));
    assertEquals(4, maxArrayHeap.rightChildIndex(1));
    assertEquals(8, maxArrayHeap.rightChildIndex(3));

    int result = maxArrayHeap.rightChild(0);

    assertEquals(2, result);

    result = maxArrayHeap.rightChild(1);
    assertEquals(4, result);

    result = maxArrayHeap.rightChild(3);
    assertEquals(1, result);

    try {
      maxArrayHeap.rightChild(8);
      fail();
    } catch (IndexOutOfBoundsException e) {
    }
  }

  public void testBuildMaxHeap() {
    final MaxArrayHeap<Integer> maxArrayHeap = new MaxArrayHeap<Integer>(
        Arrays.asList(5, 2, 6, 32, 4, 6, 8, 3, 1));

    maxArrayHeap.buildMaxHeap();

    assertEquals("MaxArrayHeap{list=[32,5,8,3,4,6,6,2,1]}", maxArrayHeap.toString());
  }

  public void testAdd() {
    final MaxArrayHeap<Integer> maxArrayHeap = new MaxArrayHeap<Integer>(4);

    maxArrayHeap.add(5);
    maxArrayHeap.add(2);
    maxArrayHeap.add(6);

    assertEquals(6, (int) maxArrayHeap.get(0));
    assertEquals(2, (int) maxArrayHeap.get(1));
    assertEquals(5, (int) maxArrayHeap.get(2));

    maxArrayHeap.add(32);
    assertEquals(32, (int) maxArrayHeap.get(0));
    assertEquals(6, (int) maxArrayHeap.get(1));
    assertEquals(5, (int) maxArrayHeap.get(2));
    assertEquals(2, (int) maxArrayHeap.get(3));
  }

  public void testPop() {
    final MaxArrayHeap<Integer> maxArrayHeap = new MaxArrayHeap<Integer>(4);

    maxArrayHeap.add(5);
    maxArrayHeap.add(2);
    maxArrayHeap.add(6);
    maxArrayHeap.add(10);

    assertEquals(10, (int) maxArrayHeap.pop());
    assertEquals(6, (int) maxArrayHeap.pop());
    assertEquals(5, (int) maxArrayHeap.pop());
    assertEquals(2, (int) maxArrayHeap.pop());

    assertNull(maxArrayHeap.pop());
  }

  public void testRemove() {
    final MaxArrayHeap<Integer> maxArrayHeap = new MaxArrayHeap<Integer>(4);

    maxArrayHeap.add(5);
    maxArrayHeap.add(2);
    maxArrayHeap.add(6);
    maxArrayHeap.add(10);

    assertTrue(maxArrayHeap.remove(6));

    assertEquals(10, (int) maxArrayHeap.get(0));
    assertEquals(5, (int) maxArrayHeap.get(1));
    assertEquals(2, (int) maxArrayHeap.get(2));
  }
}
