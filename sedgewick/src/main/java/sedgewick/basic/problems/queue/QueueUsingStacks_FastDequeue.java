package sedgewick.basic.problems.queue;

import sedgewick.basic.ds.queue.Queue;
import sedgewick.basic.ds.stack.ResizingArrayStack;
import sedgewick.basic.ds.stack.Stack;

import java.util.Iterator;
import java.util.Objects;

/**
 * {@link QueueUsingStacks_FastDequeue} implements a queue using two stacks internally.
 * <p>
 *     EnQueue operation is O(n)
 *     DeQueue operation is 0(1)
 * </p>
 * @param <E> The underlying Type
 */
public final class QueueUsingStacks_FastDequeue<E> implements Queue<E> {
    private final Stack<E> stack1 = new ResizingArrayStack<>();
    private final Stack<E> stack2 = new ResizingArrayStack<>();

    private int activeStackIndex = 0;

    @Override
    public void enqueue(final E item) {
        Stack<E> activeStack = getActiveStack();
        Stack<E> workStack = getWorkStack();

        workStack.push(Objects.requireNonNull(item));
        while (!activeStack.isEmpty())
            workStack.push(activeStack.pop());
        toggleActiveStack();
    }

    @Override
    public E dequeue() {
        return getActiveStack().pop();
    }

    @Override
    public int size() {
        return getActiveStack().size();
    }

    @Override
    public boolean isEmpty() {
        return getActiveStack().isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    private Stack<E> getActiveStack() {
        return (this.activeStackIndex == 0) ? this.stack1 : this.stack2;
    }

    private Stack<E> getWorkStack() {
        return (this.activeStackIndex != 0) ? this.stack1 : this.stack2;
    }

    private Stack<E> toggleActiveStack() {
        this.activeStackIndex = (this.activeStackIndex + 1) & 1;
        return getActiveStack();
    }
}
