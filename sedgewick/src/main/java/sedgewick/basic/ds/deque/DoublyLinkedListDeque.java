package sedgewick.basic.ds.deque;

import java.util.Objects;

/**
 * {@link DoublyLinkedListDeque} is an implementation of Deque using {@code DoublyLinkedList}
 * @param <T>
 */
public class DoublyLinkedListDeque<T> implements IDeque<T> {
    private static class Node<T> {
        T element;
        Node<T> next = null;
        Node<T> prev = null;

        Node(final T value) {
            this.element = value;
        }
    }

    private Node<T> left = null;
    private Node<T> right = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void pushLeft(T value) {
        Node<T> node = new Node<>(value);
        // handling of empty list
        if(this.left == null) {
            this.left = this.right = node;
        } else { // add node to the left and update left position
            node.next = this.left;
            this.left.prev = node;
            this.left = node;
        }

        ++size;
    }

    @Override
    public void pushRight(T value) {
        Node<T> node = new Node<>(value);
        // handling of empty list
        if(this.left == null) {
            this.left = this.right = node;
        } else { // add node to the right and update right position
            node.prev = this.right;
            this.right.next = node;
            this.right = node;
        }

        ++size;
    }

    @Override
    public T popLeft() {
        if(this.left != null) {
            --size;
            Node<T> node = this.left;

            if(this.left == this.right) {
                this.left = this.right = null;
            } else {
                this.left = this.left.next;
                this.left.prev = null;
            }

            node.prev = node.next = null;   // delink node for GC
            return node.element;
        }

        throw new IllegalArgumentException("popLeft attempted on empty deque!");
    }

    @Override
    public T popRight() {
        if(this.right != null) {
            --size;
            Node<T> node = this.right;

            if(this.left == this.right) {
                this.left = this.right = null;
            } else {
                this.right = this.right.prev;
                this.right.next = null;
            }

            node.prev = node.next = null;
            return node.element;
        }

        throw new IllegalArgumentException("popLeft attempted on empty deque!");
    }
}
