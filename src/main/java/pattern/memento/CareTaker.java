package pattern.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
  List<Originator.Memento> savedStates = new ArrayList<>();

  Originator originator = new Originator("");

  void write(String string){
    originator.setState(string);
  }

  String read(){
    return originator.getState();
  }

  void save(){
    savedStates.add(originator.saveToMemento());
  }

  void restore(int stateNumber){
    originator.restoreFromMemento(savedStates.get(stateNumber));
  }

}
