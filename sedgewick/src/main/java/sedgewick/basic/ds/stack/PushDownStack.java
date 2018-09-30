package sedgewick.basic.ds.stack;

import java.util.Iterator;

public class PushDownStack<Item> implements Iterable<Item> {
    private Node head = null;
    private int size = 0;

    private class Node {
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

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void push(final Item item) {
        Node old = head;
        head = new Node(item, old);
        ++size;
    }

    public Item pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException(String.format("%s is empty!", getClass().getSimpleName()));
        Item item = head.value;
        head = head.next;
        --size;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Item> {
        Node itr = head;

        @Override
        public boolean hasNext() {
            if(itr != null) {
                return itr.next != null;
            }
            return false;
        }

        @Override
        public Item next() {
            Item value = itr.value;
            itr = itr.next;
            return value;
        }
    }
}
