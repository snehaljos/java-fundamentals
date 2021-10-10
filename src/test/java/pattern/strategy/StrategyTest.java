package pattern.strategy;

import junit.framework.TestCase;

/**
 * @author Labnann
 */

public class StrategyTest extends TestCase {

  public void test() {
    Context context = new Context();

    context.setStrategy(new ConcreteStrategy1());
    assertEquals(1, context.executeStrategy());

    context.setStrategy(new ConcreteStrategy2());
    assertEquals(2, context.executeStrategy());

    context.setStrategy(new ConcreteStrategy3());
    assertEquals(3, context.executeStrategy());

  }
}
