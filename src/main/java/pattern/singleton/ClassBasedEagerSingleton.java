package pattern.singleton;

/**
 * A class based eager singleton. This singleton instantiates itself as soon as the class is loaded;
 * its single instance is then always available as a public static final field.
 * @author berry120
 */
public class ClassBasedEagerSingleton {

  public static final ClassBasedEagerSingleton INSTANCE = new ClassBasedEagerSingleton();

  private ClassBasedEagerSingleton() {}
}
