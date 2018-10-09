package sedgewick.basic.ds.linkedlist;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> prev = null;
        Node<T> next = null;

        Node(Node<T> before, final T value) {
            this.value = value;
            if(before != null) {
                this.next = before.next;
                this.prev = before;
                before.next = this;
            }
        }

        Node(final T value) {
            this(null, value);
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;

    /**
     * Append a new node at the end.
     * @param value : New node's value
     */
    public void append(final T value) {
        this.tail = new Node<>(this.tail, value);
        if(this.head == null) {
            this.head = this.tail;
        }
    }

    /**
     * Insert at head position
     * @param value : New node's value
     */
    public void insertHead(final T value) {
        Node<T> newHead = new Node<>(value);
        if(this.head == null) {
            this.tail = newHead;
        } else {
            newHead.next = this.head.next;
            this.head.prev = newHead;
        }

        this.head = newHead;
    }

    public void insertAfter(final Node<T> previous, final T value) {
        if(previous != null) {
            Node<T> node = new Node<>(previous, value);
        }
    }

    public void insertBefore(final Node<T> next, final T value) {
        if(next != null) {
            Node<T> node = new Node<>(value);
            node.prev = next.prev;
            node.next = next;
            next.prev = node;
        }
    }

    public void remove(Node<T> node) {
        if(node != null) {
            // condition to delete header
            if(this.head == node) {
                // special handling for a single element list
                if(this.head == this.tail) {
                    this.head = this.tail = null;
                    return;
                }

                this.head = node.next;
                this.head.prev = null;
            } else {
                Node<T> previousNode = node.prev;
                previousNode.next = node.next;
                node.next.prev = previousNode;
            }

            // isolate node to ensure its GCed
            node.prev = null;
            node.next = null;
        }
    }
}
