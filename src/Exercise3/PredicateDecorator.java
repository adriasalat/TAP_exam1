package Exercise3;

import java.util.function.Predicate;

/**
 * Solution to exercise 2.b
 * @author Adrià Salat
 */
public class PredicateDecorator<T> implements Predicate<T> {
    
    private Predicate<T> client;
    private int counter;

    public PredicateDecorator(Predicate<T> pred) {
        this.client = pred;
        counter = 0;
    }

    public int getCountTest() { return counter; }

    @Override
    public boolean test(T t) {
        counter++;
        return client.test(t);
    }
}
