package pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker class: The class that handles the save and load of Originator
 *
 * @author Labnann
 */

public class Caretaker {
  private final List<Originator.Memento> savedStates = new ArrayList<>();
  private final Originator originator = new Originator("");

  public void write(String string) {
    originator.setState(string);
  }

  public String read() {
    return originator.getState();
  }

  public void save() {
    savedStates.add(originator.saveToMemento());
  }

  public void load(int stateNumber) {
    originator.restoreFromMemento(savedStates.get(stateNumber));
  }

  public int getStateCount() {
    return this.savedStates.size();
  }

}
