package sedgewick.basic.ds.linkedlist;

import java.util.NoSuchElementException;

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

    public T pop() {
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
        throw new NoSuchElementException();
    }

    public T top() {
        if(isEmpty())
            throw new NoSuchElementException();
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

    public int size() {
        int elementsNum = 0;

        Node<T> node = this.top;
        while(node != null) {
            node = node.next;
            ++elementsNum;
        }

        return elementsNum;
    }
}
