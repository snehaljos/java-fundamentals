package pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject class for Observer Pattern
 *
 * @author Labnann
 */


public class Subject {

  Data data;

  List<Observer> observers = new ArrayList<>();

  /**
   * @param observer to add to the observers list.
   */
  void addObserver(Observer observer) {
    observers.add(observer);
  }

  /**
   * @param observer to remove from the observers list
   */

  void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
   * Arbitrary Data changer function to simulate change of Subject's state
   */

  void setData(Data data) {
    this.data = data;
    notifyObserver();
  }

  /**
   * Method that notifies all the listed observer By calling Observer.update()
   */
  private void notifyObserver() {
    observers.forEach(observer -> observer.update(data));
  }

}
