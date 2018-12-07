package sedgewick.basic.problems.queue;

import org.jetbrains.annotations.NotNull;
import sedgewick.basic.ds.queue.Queue;
import sedgewick.basic.ds.stack.ResizingArrayStack;
import sedgewick.basic.ds.stack.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Enqueue is O(1) while Dequeue is O(n)
 * @param <E> The underlying type
 */
public final class QueueUsingStacks_FastEnqueue <E> implements Queue<E> {
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
        this.activeStack.push(value);
    }

    @Override
    public E dequeue() {
        // pop all elements from the active stack and push into the working stack
        while(!this.activeStack.isEmpty())
            this.workingStack.push(this.activeStack.pop());

        final E value = this.workingStack.pop();

        while(!this.workingStack.isEmpty())
            this.activeStack.push(this.workingStack.pop());

        return value;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
