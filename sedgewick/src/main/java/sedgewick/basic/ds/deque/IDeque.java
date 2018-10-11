package sedgewick.basic.ds.deque;

public interface IDeque<T> {
    boolean isEmpty();
    int size();
    void pushLeft(final T value);
    void pushRight(final T value);
    T popLeft();
    T popRight();
}
