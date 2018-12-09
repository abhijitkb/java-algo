package sedgewick.basic.problems.deque;

import sedgewick.basic.ds.deque.Deque;
import sedgewick.basic.ds.deque.ResizingArrayDeque;

import java.util.NoSuchElementException;

/**
 * Implementation of two stacks using a {@code Deque}
 * @param <T>
 */
public class TwoStacks <T> {
    private Deque<T> deque;
    private int leftStackSize = 0;
    private int rightStackSize = 0;

    public TwoStacks(T [] refArray) {
        this.deque = new ResizingArrayDeque<>(refArray);
    }

    public boolean isLeftStackEmpty() {
        return this.leftStackSize == 0;
    }

    public boolean isRightStackEmpty() {
        return this.rightStackSize == 0;
    }

    public int leftStackSize() {
        return this.leftStackSize;
    }

    public int rightStackSize() {
        return this.rightStackSize;
    }

    public void pushLeft(final T value) {
        this.deque.pushLeft(value);
        ++this.leftStackSize;
    }

    public void pushRight(final T value) {
        this.deque.pushRight(value);
        ++this.rightStackSize;
    }

    public T popLeft() {
        if(isLeftStackEmpty())      throw new NoSuchElementException();
        final T value = this.deque.popLeft();
        --this.leftStackSize;
        return value;
    }

    public T popRight() {
        if(isRightStackEmpty())     throw new NoSuchElementException();
        final T value = this.deque.popRight();
        --this.rightStackSize;
        return value;
    }
}
