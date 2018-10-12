package sedgewick.basic.ds.bag;

public interface Bag <T> extends Iterable<T> {
    boolean isEmpty();
    int size();
    void add(T item);
}
