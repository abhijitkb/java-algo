package sedgewick.basic.ds.deque;

public interface Deque<T> {
    boolean isEmpty();
    int size();
    void pushLeft(final T value);
    void pushRight(final T value);
    T popLeft();
    T popRight();
    T head();
    T tail();
}
