package pattern.observer;

/**
 * Observer Interface to create Observers
 *
 * @author Labnann
 */

public interface Observer {

  /**
   * Observer implementations receives Data from Subject with this method. The implementations
   * handle the data in their own way
   *
   * @param data Data to receive from Subject
   */

  void update(Data data);

  /**
   * Arbitrary method to demonstrate Observer Pattern
   *
   * @return Data
   */

  Data getData();
}




