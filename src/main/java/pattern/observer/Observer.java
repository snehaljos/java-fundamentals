package pattern.observer;


import java.util.ArrayList;
import java.util.List;

interface Observer {

  void update(Data data);

  Data getData();
}


class Subject {

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


class Data {

  int data;

  Data(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }
}


class ConcreteObserver implements Observer {


  Data observerData = null;

  @Override
  public void update(Data data) {
    this.observerData = data;
  }

  public Data getData() {
    return this.observerData;
  }
}




