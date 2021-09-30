package pattern.singleton;

/**
 * A class-based lazy singleton. This singleton doesn't instantiate itself on class loading, but
 * instead waits until the first time getInstance() is called. getInstance() uses double checked
 * locking to remain thread-safe while not attracting the performance overhead of synchronisation
 * each time it is called.
 * @author berry120
 */
public class ClassBasedLazySingleton {

  private static volatile ClassBasedLazySingleton INSTANCE;

  private ClassBasedLazySingleton() {}

  public static ClassBasedLazySingleton getInstance() {
    if (INSTANCE == null) {
      synchronized (ClassBasedLazySingleton.class) {
        if (INSTANCE == null) {
          INSTANCE = new ClassBasedLazySingleton();
        }
      }
    }
    return INSTANCE;
  }
}
