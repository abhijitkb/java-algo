package sedgewick.basic.problems.steque;

import sedgewick.basic.ds.stack.ResizingArrayStack;
import sedgewick.basic.ds.stack.Stack;

import java.util.NoSuchElementException;

/**
 * Steque implemented using 2 stacks
 * @param <E> Underlying element type for which Steque is going to be used.
 */
public final class StequeWithStacks <E> {
    private final Stack<E> head = new ResizingArrayStack<>();
    private final Stack<E> tail = new ResizingArrayStack<>();

    /**
     * Returns the logical head element of the steque without removing it.
     * @return head stack's top if not empty; else returns tail stack's top
     * @throws NoSuchElementException iff steque is empty
     */
    public E top() {
        return this.head.isEmpty() ? this.tail.top() : this.head.top();
    }

    /**
     * Extracts the logical head element of the steque.
     * @return head stack's pop if not empty; else returns tail stack's pop
     * @throws NoSuchElementException iff steque is empty
     */
    public E pop() {
        return this.head.isEmpty() ? this.tail.pop() : this.head.pop();
    }

    /**
     * Gets the total number of elements present in the steque
     * @return {@code head.size()} + {@code tail.size()}
     */
    public int size() {
        return this.head.size() + this.tail.size();
    }

    /**
     * Checks to see if the steque does not have any elements.
     * @return {@code head.isEmpty()} <b>&&</b> {@code tail.isEmpty()}
     */
    public boolean isEmpty() {
        return this.head.isEmpty() && this.tail.isEmpty();
    }

    /**
     * Add an item into {@code Steque} at the head
     * @param item Input to be pushed into {@code Steque}
     */
    public void push(final E item) {
        this.head.push(item);
    }

    /**
     * Add an item into {@code Steque} at the tail
     * @param item Input to be pushed into {@code Steque}
     */
    public void enqueue(final E item) {
        int tailEleCnt = this.tail.size();

        while(!this.tail.isEmpty())
            this.head.push(this.tail.pop());

        this.tail.push(item);

        while(tailEleCnt-- > 0) {
            this.tail.push(this.head.pop());
        }
    }
}
