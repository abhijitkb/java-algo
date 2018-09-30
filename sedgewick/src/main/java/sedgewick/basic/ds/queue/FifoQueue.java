package sedgewick.basic.ds.queue;

import java.util.Iterator;

public class FifoQueue<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class Node {
        Item item;
        Node next;

        Node(final Item item, Node next) {
            this.item = item;
            this.next = next;
        }

        Node(final Item item) {
            this(item, null);
        }
    }

    public boolean isEmpty() { return this.head == null; }
    public int size() { return this.size; }

    public void enqueue(final Item item) {
        Node tail = this.tail;
        this.tail = new Node(item);
        if(isEmpty())   head = this.tail;
        else            tail.next = this.tail;
        ++size;
    }

    public Item dequeue() {
        Item item = head.item;
        this.head = this.head.next;
        --size;
        if(isEmpty()) this.tail = null;
        return item;
    }

    private class QueueIterator implements Iterator<Item> {
        private Node node = head;

        @Override
        public boolean hasNext() {
            return this.node != null;
        }

        @Override
        public Item next() {
            Item value = node.item;
            node = node.next;
            return value;
        }
    }
}
