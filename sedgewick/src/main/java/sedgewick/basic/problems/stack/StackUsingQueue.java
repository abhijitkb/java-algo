package sedgewick.basic.problems.stack;

import sedgewick.basic.ds.stack.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * {@link StackUsingQueue} uses Queue internally to implement a Stack.
 * <p>
 *     The push operation will be O(n)
 *     The top and pop operations will be O(1)
 * </p>
 */
public final class StackUsingQueue <E> implements Stack<E> {
    private final Queue<E> queue = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public void push(E item) {
        this.queue.offer(item);

        int elements = this.queue.size();

        // continue to dequeue and enqueue till we reach the tail - effectively making the tail the head after we are done.
        while(elements > 1) {
            this.queue.offer(this.queue.remove());
            --elements;
        }
    }

    @Override
    public E pop() {
        return this.queue.remove();
    }

    @Override
    public E top() {
        return this.queue.element();
    }
}
