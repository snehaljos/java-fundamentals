package pattern.observer;

/**
 * An implementation of the Observer interface
 *
 * @author Labnann
 */

public class ConcreteObserver implements Observer {


  Data observerData = null;

  @Override
  public void update(Data data) {
    this.observerData = data;
  }

  public Data getData() {
    return this.observerData;
  }
}
