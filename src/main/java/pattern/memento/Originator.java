package pattern.memento;



public class Originator {
  private String state;

  Originator(String state) {
    this.state = state;
  }

  void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public Memento saveToMemento() {
    return new Memento(this.state);
  }

  public void restoreFromMemento(Memento memento) {
    this.state = memento.getState();
  }


  static class Memento {
    String stateData;

    Memento(String state) {
      this.stateData = state;
    }

    String getState() {
      return this.stateData;
    }

  }


}


