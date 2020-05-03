package datastructures.math;

import java.util.Objects;

/**
 * Immutable generic tuple
 *
 * @param <T> Type of the tuple
 * @author Lorenz Nickel
 */
public class Tuple<T> {

  private final T a;
  private final T b;

  public Tuple(T a, T b) {
    this.a = a;
    this.b = b;
  }

  public T getA() {
    return this.a;
  }

  public T getB() {
    return this.b;
  }

  /**
   * @param a value for <code>{@link Tuple#a}</code> of the new tuple
   * @return an independent tuple with the same value of <code>{@link Tuple#b}</code>
   */
  public Tuple<T> withA(T a) {
    return new Tuple<>(a, this.b);
  }

  /**
   * @param b value for <code>{@link Tuple#b}</code> of the new tuple
   * @return an independent tuple with the same value of <code>{@link Tuple#a}</code>
   */
  public Tuple<T> withB(T b) {
    return new Tuple<>(this.a, b);
  }

  @Override
  public String toString() {
    return "Tuple{" +
        "a=" + a +
        ", b=" + b +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tuple<?> tuple = (Tuple<?>) o;
    return Objects.equals(a, tuple.a) &&
        Objects.equals(b, tuple.b);
  }

  @Override
  public int hashCode() {
    return Objects.hash(a, b);
  }

}
