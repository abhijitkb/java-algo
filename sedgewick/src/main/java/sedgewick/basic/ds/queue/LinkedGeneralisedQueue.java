package sedgewick.basic.ds.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedGeneralisedQueue <T> implements Queue<T> {
    static class Node<T> {
        T value;
        Node next = null;

        Node(final T value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public LinkedGeneralisedQueue() {}

    public LinkedGeneralisedQueue(final Queue<T> queue) {
        Queue<T> temp = new LinkedGeneralisedQueue<>();
        while(!queue.isEmpty())
            temp.enqueue(queue.dequeue());

        T value;
        while (!temp.isEmpty()) {
            value = temp.dequeue();
            queue.enqueue(value);
            enqueue(value);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void enqueue(T value) {
        Node<T> node = new Node(value);
        if(isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    @Override
    public T dequeue() {
        return dequeue(1);
    }

    public T dequeue(int index) {
        if(index > this.size)
            throw new NoSuchElementException();

        // special handling for a single element list
        if(this.head == this.tail) {
            final T value = this.head.value;
            this.head = this.tail = null;
            return value;
        }

        Node<T> beforeDelNode = null;
        Node<T> nodeToDelete;

        // handling for deleting of header
        if(index == 1) {
            nodeToDelete = this.head;
        } else {
            beforeDelNode = this.head;

            for (int i = 2; i < index; ++i) {
                beforeDelNode = beforeDelNode.next;
            }

            nodeToDelete = beforeDelNode.next;
            beforeDelNode.next = nodeToDelete.next;
            nodeToDelete.next = null;
        }

        if(nodeToDelete == this.head)
            this.head = nodeToDelete.next;
        if(nodeToDelete == tail)
            this.tail = beforeDelNode;

        this.size--;
        return nodeToDelete.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();

            final T value = current.value;
            current = current.next;
            return value;
        }
    }
}
