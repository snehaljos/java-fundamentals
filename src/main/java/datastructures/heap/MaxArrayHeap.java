package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * A max heap based on an array list. This max heap can also be used as a max-priority queue using
 * MaxArrayHeap{@link #add(Comparable)} and MaxArrayHeap{@link #pop()}
 *
 * @param <E> specifies the type of elements the max heap contains
 * @author thepn
 * @see <a href="https://en.wikipedia.org/wiki/Min-max_heap">Min-Max-Heaps (Wikipedia)</a>
 */
public class MaxArrayHeap<E extends Comparable<? super E>> {

  private final List<E> list;


  public MaxArrayHeap(final List<E> list) {
    this.list = list;
  }

  public MaxArrayHeap(final int size) {
    this.list = new ArrayList<>(size);
  }

  /**
   * heapifys the path of element at index i down
   *
   * @param i - index of element
   */
  private void maxHeapify(final int i) {
    int max = i;

    if (list.size() > leftChildIndex(i) && leftChild(i).compareTo(get(i)) > 0) {
      max = leftChildIndex(i);
    }

    if (list.size() > rightChildIndex(i) && rightChild(i).compareTo(get(max)) > 0) {
      max = rightChildIndex(i);
    }

    // maximum found. Swap elements and do recursive call
    if (max != i) {
      swap(max, i);
      maxHeapify(max);
    }
  }

  /**
   * @param i - index of the current element.
   * @return the array index of the parent element.
   * @throws IllegalArgumentException  when the given element has no parent element.
   * @throws IndexOutOfBoundsException - when the element at index i does not exist.
   */
  public int parentIndex(final int i) {
    if (i == 0) {
      throw new IllegalArgumentException("this element has no parent!");
    }

    if (i >= list.size()) {
      throw new IndexOutOfBoundsException();
    }

    return Math.floorDiv(i - 1, 2);
  }

  /**
   * @param i - index of the current element.
   * @return the parent element.
   * @throws IllegalArgumentException  when the given element has no parent element.
   * @throws IndexOutOfBoundsException - when the element at index i does not exist.
   */
  public E parent(final int i) {
    return list.get(parentIndex(i));
  }

  /**
   * @param i - index of the current element
   * @return the index of the right child element.
   */
  public int rightChildIndex(final int i) {
    return (i + 1) * 2;
  }

  /**
   * @param i - index of the current element
   * @return the index of the left child element.
   */
  public int leftChildIndex(final int i) {
    return (i + 1) * 2 - 1;
  }

  /**
   * @param i - index of the current element
   * @return the left child element.
   * @throws IndexOutOfBoundsException when the current element has no children.
   */
  public E leftChild(final int i) {
    final int child = leftChildIndex(i);

    if (child >= list.size()) {
      throw new IndexOutOfBoundsException();
    }

    return list.get(child);
  }

  /**
   * @param i - index of the current element
   * @return the right child element.
   * @throws IndexOutOfBoundsException when the current element has no children.
   */
  public E rightChild(final int i) {
    final int child = rightChildIndex(i);

    if (child >= list.size()) {
      throw new IndexOutOfBoundsException();
    }

    return list.get(child);
  }

  /**
   * Returns the element at the specified position in this heap.
   *
   * @param i index of the element to return
   * @return the element at the specified position in this heap
   * @throws IndexOutOfBoundsException if the index is out of range (<tt>index &lt; 0 || index &gt;=
   *                                   size()</tt>)
   * @see ArrayList#get(int)
   */
  public E get(final int i) {
    return list.get(i);
  }

  /**
   * Swaps the two given elements.
   *
   * @param i - index of first element
   * @param j - index of second element
   * @throws IndexOutOfBoundsException when at least one of the indices is too large.
   * @see MaxArrayHeap#get(int)
   */
  public void swap(final int i, final int j) {
    E temp = get(i);
    list.set(i, get(j));
    list.set(j, temp);
  }

  /**
   * Builds the max heap property.
   */
  public void buildMaxHeap() {
    for (int i = list.size() / 2; i >= 0; i--) {
      maxHeapify(i);
    }
  }

  /**
   * Adds an element to the heap and ensures the max heap invariant if it was before.
   *
   * @param element - the element to be added
   */
  public void add(final E element) {
    int index = list.size();
    list.add(element);

    // "bubble up" the element until the heap property is reached
    while (index > 0 && parent(index).compareTo(get(index)) < 0) {
      swap(parentIndex(index), index);
      index = parentIndex(index);
    }
  }

  /**
   * Pops the maximum element from the heap if the heap is a max heap.
   *
   * @return null if the heap is empty or else the removed element.
   */
  public E pop() {
    if (list.size() == 0) {
      return null;
    }

    final E element = list.get(0);

    // sets the first list element to the last one
    list.set(0, list.get(list.size() - 1));
    // removes the last element
    list.remove(list.size() - 1);
    maxHeapify(0);

    return element;
  }

  /**
   * Removes an element from the heap and rebuilds the max heap.
   *
   * @param element The element that should be removed from the heap
   * @return <tt>true</tt> if this heap contained the specified element
   */
  public boolean remove(E element) {
    boolean removed = list.remove(element);
    buildMaxHeap();
    return removed;
  }

  /**
   * @return the maximum element of the heap
   * @throws IndexOutOfBoundsException if the heap is empty
   */
  public E max() {
    return list.get(0);
  }

  @Override
  public String toString() {
    if (list.isEmpty()) {
      return "MaxArrayHeap{list=[]}";
    }

    final StringBuilder stringBuilder = new StringBuilder();

    list.forEach(e -> stringBuilder.append(",").append(e.toString()));
    return "MaxArrayHeap{list=[" + stringBuilder.toString().substring(1) + "]}";
  }
}
