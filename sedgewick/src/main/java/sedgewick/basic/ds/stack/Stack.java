package sedgewick.basic.ds.stack;

public interface Stack<T> {

    boolean isEmpty();
    int size();
    void push(final T item) throws Exception;
    T pop() throws Exception;
    T top() throws Exception;
}
