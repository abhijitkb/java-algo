package sedgewick.basic.ds.queue;

public interface Queue <T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    void enqueue(final T value);
    T dequeue();
}
