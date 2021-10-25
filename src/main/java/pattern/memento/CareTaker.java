package pattern.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
  private List<Originator.Memento> savedStates = new ArrayList<>();

  private Originator originator = new Originator("");

  public void write(String string){
    originator.setState(string);
  }

  public String read(){
    return originator.getState();
  }

  public void save(){
    savedStates.add(originator.saveToMemento());
  }

  public void load(int stateNumber){
    originator.restoreFromMemento(savedStates.get(stateNumber));
  }

  public int getStateCount(){
    return this.savedStates.size();
  }

}
