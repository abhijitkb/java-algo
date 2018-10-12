package sedgewick.basic.problems.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MoveToFront implements Iterable<Character> {
    private static class CharNode {
        char value;
        CharNode next = null;

        CharNode(final char value) {
            this.value = value;
        }
    }

    private CharNode head = null;

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;

        for(CharNode current = this.head; current != null; current = current.next)
            ++size;

        return size;
    }

    /**
     * {@code value} must always be at the header. If its a duplicate then ensure that the node is moved to the front
     * @param value
     */
    public void offer(final char value) {
        CharNode node;
        if(isEmpty()) {
            node = new CharNode(value);
        } else {
            // Header is already having value .. no need to process it
            if (this.head.value == value)
                return;

            // push existing matching node to front if found else insert the node at the head
            CharNode prevNode = getPrevNode(value);
            // found duplicate
            if (prevNode != null) {
                // extract the existing node
                node = prevNode.next;
                // delink the existing node from the list
                prevNode.next = node.next;
            } else {
                // place the node on the list's head
                node = new CharNode(value);
            }

            node.next = this.head;
        }

        this.head = node;

    }

    private CharNode getPrevNode(final char value) {
        CharNode prevNode = null;
        CharNode current = this.head;

        while(current != null) {
            if(current.value == value)
                break;
            prevNode = current;
            current = current.next;
        }

        // if no match is found return null
        if(current == null)
            prevNode = null;

        return prevNode;
    }

    @Override
    public Iterator<Character> iterator() {
        return new MoveToFirstIterator();
    }

    private class MoveToFirstIterator implements Iterator<Character> {
        private CharNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Character next() {
            if(!hasNext())
                throw new NoSuchElementException();
            char value = current.value;
            current = current.next;
            return value;
        }
    }

}
