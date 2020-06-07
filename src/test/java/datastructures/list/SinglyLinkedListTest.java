package datastructures.list;

import junit.framework.TestCase;

/**
 * @author Lorenz Nickel
 */
public class SinglyLinkedListTest extends TestCase {

  public void testAdd() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);
  }

  public void testRemove() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    assertFalse(list.remove(3));
    assertTrue(list.remove(2));
    assertTrue(list.remove(0));
    assertTrue(list.remove(1));
    assertFalse(list.remove(1));
  }

  public void testSize() {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
    list.add(0);
    assertFalse(list.isEmpty());
    assertEquals(1, list.size());
    list.add(0);
    assertEquals(2, list.size());
    list.add(1);
    assertEquals(3, list.size());
    list.remove(0);
    assertEquals(2, list.size());
    list.remove(0);
    list.remove(1);
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
  }

  public void testContains() {
    SinglyLinkedList<Boolean> list = new SinglyLinkedList<>();
    assertFalse(list.contains(true));
    assertFalse(list.contains(false));
    list.add(true);
    assertFalse(list.contains(false));
    assertTrue(list.contains(true));
    list.add(true);
    assertFalse(list.contains(false));
    assertTrue(list.contains(true));
    list.add(false);
    assertTrue(list.contains(false));
    assertTrue(list.contains(true));
    list.remove(true);
    assertTrue(list.contains(false));
    assertTrue(list.contains(true));
    list.remove(true);
    assertTrue(list.contains(false));
    assertFalse(list.contains(true));
    list.remove(false);
    assertFalse(list.contains(false));
    assertFalse(list.contains(true));
  }

  public void testNullSafety() {
    SinglyLinkedList<String> list = new SinglyLinkedList<>();
    list.add(null);
    assertTrue(list.contains(null));
    assertEquals(1, list.size());
    list.add(null);
    assertEquals(2, list.size());
    list.add("A");
    assertEquals(3, list.size());
    list.add(null);
    assertEquals(4, list.size());
    list.remove(null);
    assertEquals(3, list.size());
    list.remove(null);
    assertEquals(2, list.size());
    list.remove("A");
    assertEquals(1, list.size());
    assertTrue(list.contains(null));
    list.remove(null);
    assertFalse(list.contains(null));
    assertEquals(0, list.size());
  }

}
