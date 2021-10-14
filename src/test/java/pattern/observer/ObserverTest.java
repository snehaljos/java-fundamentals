package pattern.observer;

import junit.framework.TestCase;


public class ObserverTest extends TestCase {

  Observer observer1 = new ConcreteObserver();
  Observer observer2 = new ConcreteObserver();

  Subject subject = new Subject();
  Data data1 = new Data(10);
  Data data2 = new Data(20);
  Data data3 = new Data(30);

  public void test() {

    subject.addObserver(observer1);
    subject.setData(data1);

    assertEquals(data1, observer1.getData());
    assertNull(observer2.getData());

    subject.addObserver(observer2);
    assertEquals(data1, observer1.getData());
    assertNull(observer2.getData());

    subject.setData(data2);
    assertEquals(data2, observer1.getData());
    assertEquals(data2, observer2.getData());

    subject.removeObserver(observer1);

    subject.setData(data3);
    assertEquals(data3, observer2.getData());
    assertEquals(data2, observer1.getData());


  }
}
