package sedgewick.basic.ds.stack;

public interface Stack<T> {

    boolean isEmpty();
    int size();
    void push(final T item);
    T pop();
    T top();
}
