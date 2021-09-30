package pattern.singleton;

import junit.framework.TestCase;

/**
 * @author berry120
 */
public class ClassBasedEagerSingletonTest extends TestCase {

  public void test() {
    ClassBasedEagerSingleton s1 = ClassBasedEagerSingleton.INSTANCE;
    ClassBasedEagerSingleton s2 = ClassBasedEagerSingleton.INSTANCE;

    assertSame(s1, s2);
  }
}