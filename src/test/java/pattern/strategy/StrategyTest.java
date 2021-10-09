package pattern.strategy;

import junit.framework.TestCase;

/**
 * @author Labnann
 */

public class StrategyTest extends TestCase {

  public void test() {
    Strategy strategy = new ConcreteStrategy1();
    assertEquals(1,strategy.runAlgorithm());

    strategy = new ConcreteStrategy2();
    assertEquals(2,strategy.runAlgorithm());

    strategy = new ConcreteStrategy3();
    assertEquals(3,strategy.runAlgorithm());

  }
}
