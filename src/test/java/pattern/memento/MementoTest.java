package pattern.memento;

import junit.framework.TestCase;

public class MementoTest extends TestCase {

  public void test() {

    Originator originator = new Originator();
    Caretaker caretaker = new Caretaker(originator);

    assertEquals(0, caretaker.getStateCount());

    originator.write("Hello");
    assertEquals("Hello", originator.read());
    caretaker.save();
    assertEquals(1, caretaker.getStateCount());

    originator.write("Hello World");
    assertEquals("Hello World", originator.read());
    caretaker.save();
    assertEquals(2, caretaker.getStateCount());


    caretaker.load(0);
    assertEquals("Hello", originator.read());
    assertEquals(2, caretaker.getStateCount());


    caretaker.load(1);
    assertEquals("Hello World", originator.read());
    assertEquals(2, caretaker.getStateCount());
  }
}
