package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

  Data data;

  List<Observer> observers = new ArrayList<>();

  void addObserver(Observer observer) {
    observers.add(observer);
  }


  void removeObserver(Observer observer) {
    observers.remove(observer);
  }


  void setData(Data data) {
    this.data = data;
    notifyObserver();
  }


  private void notifyObserver() {
    observers.forEach(observer -> observer.update(data));
  }

}
