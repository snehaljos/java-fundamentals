package pattern.observer;


import java.util.ArrayList;
import java.util.List;

interface Observer {
  void update(SubjectDataFormat data);
}


class Subject {

  int data;

  List<Observer> observers = new ArrayList<>();

  void addObserver(Observer observer) {
    observers.add(observer);
  }


  void removeObserver(Observer observer) {
    observers.remove(observer);
  }


  void setData(int data) {
    this.data = data;
    notifyObserver();
  }


  private void notifyObserver() {
    observers.forEach(observer -> observer.update(new SubjectDataFormat(data)));
  }

}


class SubjectDataFormat {
  int data;

  SubjectDataFormat(int data){
    this.data = data;
  }

  public int getData() {
    return data;
  }
}


class ConcreteObserver implements Observer {

  String description = "observer 1: ";
  int observerData;

  @Override
  public void update(SubjectDataFormat data) {
    this.observerData = data.getData();
  }

  public int getObserverData() {
    return observerData;
  }
}




