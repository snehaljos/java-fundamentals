package datastructures.list;

import java.util.Objects;

/**
 * A list in which each element references its next element.
 *
 * @param <E> type of the values stored in the list
 */
public class SinglyLinkedList<E> {

  private Node head;

  /**
   * A list consists of multiple nodes. A node references its value and the subsequent element.
   * {@link Node#next} is null if its the last element of a list.
   */
  class Node {

    private E value;
    private Node next;

    Node(E value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node{" +
          "value=" + value +
          '}';
    }
  }

  /**
   * Add an element to the list.
   *
   * @param element
   */
  public void add(E element) {
    Node node = new Node(element);
    node.next = head;
    head = node;
  }

  /**
   * Remove an element from the list.
   *
   * @param element
   * @return if the element was found within the list
   */
  public boolean remove(E element) {
    if (head != null && Objects.equals(head.value, element)) {
      head = head.next;
      return true;
    }
    Node temp = head, prev = null;
    while (temp != null && !Objects.equals(temp.value, element)) {
      prev = temp;
      temp = temp.next;
    }
    if (temp == null) {
      return false;
    }
    prev.next = temp.next;
    return true;
  }

  /**
   * @return the size of the list
   */
  public int size() {
    int size = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      size++;
    }
    return size;
  }

  /**
   * @return if the list is empty
   */
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * @param element
   * @return if the list contains the element at least once
   */
  public boolean contains(E element) {
    Node temp = head;
    while (temp != null) {
      if (Objects.equals(element, temp.value)) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }
}
