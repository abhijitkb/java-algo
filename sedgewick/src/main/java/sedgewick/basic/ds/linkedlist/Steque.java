package sedgewick.basic.ds.linkedlist;

/**
 * {@link Steque} is a stack-ended queue and supports push, pop and enqueue operations
 */
public class Steque<T>  {

    static class Node<T> {
        T value;
        Node<T> next = null;
        Node<T> prev = null;
        Node(final T value) {
            this.value = value;
        }
    }

    private Node<T> top = null;
    private Node<T> bottom = null;

    public Steque() {}

    public boolean isEmpty() { return this.top == null; }

    public T pop() throws IllegalAccessException {
        if(!isEmpty()) {
            Node<T> node = this.top;
            final T value = top.value;
            if(this.top == this.bottom) {
                this.top = this.bottom = null;
            } else {
                this.top = this.top.next;
                this.top.prev = null;
            }
            node.prev = node.next = null;
            return value;
        }
        throw new IllegalAccessException("pop attempted on empty Steque");
    }

    public T top() throws IllegalAccessException {
        if(isEmpty())
            throw new IllegalAccessException("top attempted on empty Steque");
        return top.value;
    }

    public void push(final T value) {
        Node<T> node = new Node<>(value);
        // special condition when the steque is empty
        if(isEmpty()) {
            this.top = this.bottom = node;
            return;
        }

        node.next = this.top;
        this.top.prev = node;
        this.top = node;
    }

    public void enqueue(final T value) {
        Node<T> node = new Node<>(value);
        if(isEmpty()) {
            this.top = this.bottom = node;
            return;
        }

        // update tail
        node.prev = this.bottom;
        this.bottom.next = node;
        this.bottom = node;
    }
}
