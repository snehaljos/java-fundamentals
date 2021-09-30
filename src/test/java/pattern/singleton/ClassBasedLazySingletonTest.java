package pattern.singleton;

import junit.framework.TestCase;

/**
 * @author berry120
 */
public class ClassBasedLazySingletonTest extends TestCase {

  public void test() {
    ClassBasedLazySingleton s1 = ClassBasedLazySingleton.getInstance();
    ClassBasedLazySingleton s2 = ClassBasedLazySingleton.getInstance();

    assertSame(s1, s2);
  }
}