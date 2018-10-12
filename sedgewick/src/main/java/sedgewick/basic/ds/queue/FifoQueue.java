package sedgewick.basic.ds.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FifoQueue<Item> implements Queue<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private static class Node<Item> {
        Item value;
        Node next;

        Node(final Item value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(final Item value) {
            this(value, null);
        }
    }

    @Override
    public boolean isEmpty() { return this.head == null; }

    @Override
    public int size() { return this.size; }

    @Override
    public void enqueue(final Item item) {
        Node<Item> tail = this.tail;
        this.tail = new Node<>(item);
        if(isEmpty())   head = this.tail;
        else            tail.next = this.tail;
        ++size;
    }

    @Override
    public Item dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();

        Item item = head.value;
        this.head = this.head.next;
        --size;
        if(isEmpty()) this.tail = null;
        return item;
    }

    private class QueueIterator implements Iterator<Item> {
        private Node<Item> node = head;

        @Override
        public boolean hasNext() {
            return this.node != null;
        }

        @Override
        public Item next() {
            if(!hasNext())
                throw new NoSuchElementException();

            Item value = node.value;
            node = node.next;
            return value;
        }
    }
}
