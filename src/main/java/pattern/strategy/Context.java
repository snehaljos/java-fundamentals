package pattern.strategy;

/**
 * A context for strategy class
 * Note that the Context is independent
 * It does not know which algorithm is going to run
 * @author Labnann
 * */

public class Context {
  private Strategy strategy;

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  int executeStrategy(){
    return strategy.runAlgorithm();
  }
}
