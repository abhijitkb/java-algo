package sedgewick.basic.problems.deque;

import sedgewick.basic.ds.deque.Deque;
import sedgewick.basic.ds.linkedlist.Steque;
import sedgewick.basic.ds.stack.ResizingArrayStack;
import sedgewick.basic.ds.stack.Stack;

import java.util.NoSuchElementException;

/**
 * {@link DequeWithStackSteque} is a {@link Deque} implementation using {@link Stack} and {@code Steque}.
 * <p>
 *     Enqueue and Push operations are O(1).
 *     Dequeue and Top operations are O(n)
 * </p>
 * @param <E> Underlying type
 */
public final class DequeWithStackSteque<E> implements Deque<E> {
    /**
     * This stores the order in which items are pushed/enqueued into this deque; and is used for {@code push(), enqueue(), size()} operations.
     */
    private final Steque<E> steque = new Steque<>();
    /**
     * This will be used for {@code top()} and {@code dequeue()}
     */
    private final Stack<E> stack = new ResizingArrayStack<>();

    @Override
    public boolean isEmpty() {
        return this.steque.isEmpty();
    }

    @Override
    public int size() {
        return this.steque.size();
    }

    /**
     * The stack's {@code push} operations
     * @param value Input to be pushed into
     */
    @Override
    public void pushLeft(E value) {
        this.steque.push(value);
    }

    /**
     * The queue's {@ocde enqueue} operation.
     * @param value Input to be enqueued to.
     */
    @Override
    public void pushRight(E value) {
        this.steque.enqueue(value);
    }

    /**
     * The stack's {@code pop} operation.
     * @return The head element.
     * @throws NoSuchElementException iff empty
     */
    @Override
    public E popLeft() {
        return this.steque.pop();
    }

    /**
     * The queue's {@code dequeue} operation
     * @return The tail element.
     * @throws NoSuchElementException iff empty
     */
    @Override
    public E popRight() {
        if(this.steque.isEmpty())
            throw new NoSuchElementException();

        while(!this.steque.isEmpty())
            this.stack.push(this.steque.pop());

        final E value = this.stack.pop();
        while(!this.stack.isEmpty())
            this.steque.push(this.stack.pop());

        return value;
    }

    @Override
    public E head() {
        return this.steque.top();
    }

    @Override
    public E tail() {
        if(this.steque.isEmpty())
            throw new NoSuchElementException();

        while(!this.steque.isEmpty())
            this.stack.push(this.steque.pop());

        final E value = this.stack.top();
        while(!this.stack.isEmpty())
            this.steque.push(this.stack.pop());

        return value;
    }
}
