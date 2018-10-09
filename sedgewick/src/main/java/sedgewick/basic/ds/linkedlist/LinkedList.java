package sedgewick.basic.ds.linkedlist;

import java.util.Iterator;

/**
 * {@link LinkedList} : Implementation of a singly linked list.
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(final T value, final Node next) {
            this.value = value;
            this.next = next;
        }

        Node(final T value) {
            this(value, null);
        }
    }

    private Node<T> head = null;
    private Node<T> tail = head;

    public void add(final T value) {
        Node<T> newNode = new Node<>(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
        }
    }

    public boolean insertAfter(final T after, final T value) {
        Node<T> node = findNode(after);
        if(node != null) {
            node.next = new Node<>(value, node.next);
            // update tail if necessary
            if(node == this.tail) {
                tail = node.next;
            }
            return true;
        }
        return false;
    }

    /**
     * {@code remove} delete all nodes with matching node value
     * @param deleteValue Nodes with matching values are to be deleted.
     */
    public void remove(final T deleteValue) {
        Node<T> current = head;

        // special case handling deletion of header node
        if(head.value.equals(deleteValue)) {
            head = head.next; // move head to next position
            current.next = null; // orphan the original head node
            current = head; // move current to head

            // special handling for tail if the list has less than 2 nodes
            if(head == null || head.next == null) {
                tail = head;
                return;
            }
        }

        while(current.next != null) {
            if(current.next.value.equals(deleteValue))
                removeAfter(current);
        }
    }

    /**
     * {@code removeAfter} : Deletes the immediate next node of the given matching node. If
     * @param removeAfter : Input Node which needs to be delete
     */
    public Node<T> removeAfter(final Node<T> removeAfter) {
        if(removeAfter != null && removeAfter.next != null) {
            final Node<T> deletedNode = removeAfter.next;
            removeAfter.next = removeAfter.next.next;
            deletedNode.next = null; // orphan the deletedNode

            // Update tail if the deleted node was the last node
            if(removeAfter.next == null)
                tail = removeAfter;

            return deletedNode;
        }
        return null; // NO node was deleted
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    private Node<T> findNode(final T value) {
        for(Node<T> current = head; current != null; current = current.next) {
            if(value.equals(current.value))
                return current;
        }

        return null;
    }

    public boolean find(final T value) {
        Node<T> node = findNode(value);
        return node != null;
    }


    public T max() {
        T max = null;

        for(T element : this) {
            if(max == null) {
                max = element;
            } else {
                if(element.compareTo(max) > 0) {
                    max = element;
                }
            }
        }

        return max;
    }

    /**
     * Iteratively reverse the list
     */
    public void reverse() {
        Node<T> reverseHead = null;

        Node<T> newHead = head;
        Node<T> current;

        while(newHead != null) {
            current = newHead;
            // newHead to next
            newHead = current.next;

            // link current with reversed
            current.next = reverseHead;
            // update reversed
            reverseHead = current;
        }

        //
        this.tail = this.head;
        this.head = reverseHead;
    }

    /**
     * Recursively reverse the list
     * @param head : head node of a linked list
     * @return head of the reversed list
     */
    public Node<T> reverse(Node<T> head) {
        if((head == null) || (head.next == null))
            return head;

        Node<T> rest = reverse(head.next);
        rest.next = head;
        return rest;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return (this.current != null);
        }

        @Override
        public T next() {
            final T item =  this.current.value;
            this.current = this.current.next;
            return item;
        }
    }
}
