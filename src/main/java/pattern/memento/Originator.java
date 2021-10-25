package pattern.memento;


/**
 * Originator class: The class whose state is to be saved
 *
 * @author Labnann
 */

public class Originator {
  private String state = "";


  void write(String state) {
    this.state = state;
  }

  public String read() {
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


