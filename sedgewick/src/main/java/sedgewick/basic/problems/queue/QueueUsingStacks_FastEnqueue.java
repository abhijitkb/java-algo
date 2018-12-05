package sedgewick.basic.problems.queue;

import sedgewick.basic.ds.queue.Queue;
import sedgewick.basic.ds.stack.ResizingArrayStack;
import sedgewick.basic.ds.stack.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class QueueUsingStacks_FastEnqueue <E> implements Queue<E> {
    private final Stack<E> stack1 = new ResizingArrayStack<>();
    private final Stack<E> stack2 = new ResizingArrayStack<>();

    private int activeStackIndex = 0;


    @Override
    public int size() {
        return getActiveStack().size();
    }

    @Override
    public boolean isEmpty() {
        return getActiveStack().isEmpty();
    }

    @Override
    public void enqueue(E value) {
        getActiveStack().push(value);
    }

    @Override
    public E dequeue() {
        Stack<E> activeStack = getActiveStack();
        Stack<E> workStack = getWorkStack();

        // pop all elements of active stack and push them to work stack (in order)
        // pop work stack and return the popped element.
        while(!activeStack.isEmpty())
            workStack.push(activeStack.pop());
        final E item = workStack.pop();
        while(!workStack.isEmpty())
            activeStack.push(workStack.pop());

        return item;
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
