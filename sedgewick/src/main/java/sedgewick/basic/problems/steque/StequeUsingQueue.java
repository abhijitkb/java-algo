package sedgewick.basic.problems.steque;

import sedgewick.basic.ds.linkedlist.Steque;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * {@link StequeUsingQueue} is a {@link Steque} using {@link Queue} as the underlying data structure.
 */
public final class StequeUsingQueue<E> {
    private final Queue<E> queue = new ArrayDeque<>();

    public void push(final E item) {
        this.queue.offer(item);

        int numElements = this.queue.size();

        // Pull and push all the elements in the queue (except for the tail) to ensure LIFO property is enforced
        while(numElements > 1) {
            this.queue.offer(this.queue.remove());
            --numElements;
        }
    }

    /**
     * Add {@code item} to the tail
     * @param item Input.
     */
    public void enqueue(final E item) {
        this.queue.offer(item);
    }


    /**
     * Retrieves the top element without removing it.
     * @return The top element iff present
     * @throws NoSuchElementException iff empty
     */
    public E top() {
        return this.queue.element();
    }

    /**
     * Gets the top most element and removes from the head as well.
     * @return The head of steque.
     * @throws NoSuchElementException iff the steque is empty.
     */
    public E pop() {
        return this.queue.remove();
    }

    /**
     * Get the current size of steque
     * @return size of steque; type is int
     */
    public int size() {
        return this.queue.size();
    }
}
