package pattern.memento;

import junit.framework.TestCase;

public class MementoTest extends TestCase {
  public void test(){
    CareTaker careTaker = new CareTaker();

    assertEquals(0, careTaker.getStateCount());

    careTaker.write("Hello");
    assertEquals("Hello", careTaker.read());
    careTaker.save();
    assertEquals(1, careTaker.getStateCount());

    careTaker.write("Hello World");
    assertEquals("Hello World", careTaker.read());
    assertEquals(1, careTaker.getStateCount());
    careTaker.save();
    assertEquals(2, careTaker.getStateCount());

    careTaker.load(0);
    assertEquals("Hello", careTaker.read());
    assertEquals(2, careTaker.getStateCount());


    careTaker.load(1);
    assertEquals("Hello World", careTaker.read());
    assertEquals(2, careTaker.getStateCount());



  }
}
