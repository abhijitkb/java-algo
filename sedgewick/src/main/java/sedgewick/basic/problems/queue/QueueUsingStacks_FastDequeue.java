package sedgewick.basic.problems.queue;

import org.jetbrains.annotations.NotNull;
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
    private final Stack<E> activeStack = new ResizingArrayStack<>();
    private final Stack<E> workingStack = new ResizingArrayStack<>();

    @Override
    public int size() {
        return this.activeStack.size();
    }

    @Override
    public boolean isEmpty() {
        return this.activeStack.isEmpty();
    }

    @Override
    public void enqueue(E value) {
        // pop all elements from active and push them into working stack
        while(!this.activeStack.isEmpty())
            this.workingStack.push(this.activeStack.pop());

        // ensure "value" remains the last element to be "dequeued
        this.activeStack.push(value);

        // pop all from working stack and push them into active stack to simulate FIFO behaviour
        while(!this.workingStack.isEmpty())
            this.activeStack.push(this.workingStack.pop());
    }

    @Override
    public E dequeue() {
        return this.activeStack.pop();
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
