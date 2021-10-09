package pattern.strategy;

/**
 * The interface for Strategy pattern.
 * Context uses this interface to communicate with its subtypes.
 * So the context do not need to know how the algorithm is implemented.
 * @author Labnann
 */
public interface Strategy {
    int runAlgorithm();
}


