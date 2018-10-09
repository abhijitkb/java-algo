package sedgewick.basic.problems.linkedlist;

public class ReverseLinkedList {
    public static class Node<T> {
        T value;
        Node<T> next;

        Node(final T value, final Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static <T> Node<T> createLinkedList(T... values) {
        Node<T> head = null;
        Node<T> tail = head;
        for(T value : values) {
            if(head == null) {
                head = new Node<>(value, null);
                tail = head;
            } else {
                tail = tail.next = new Node<>(value, tail.next);
            }
        }
        return head;
    }

    public static <T> void printList(final Node<T> linkedList) {
        for(Node<T> current = linkedList; current != null; current = current.next) {
            System.out.printf("%s > ", current.value);
        }
        System.out.println();
    }

    public static <T> Node<T> reverse(Node<T> head) {
        if((head == null) || (head.next == null))
            return head;

        Node<T> next = head.next;
        Node<T> rest = reverse(head.next);
        next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        Node<Integer> linkedList = createLinkedList(1, 2, 3, 4, 5, 6);
        printList(linkedList);

        Node<Integer> reverse = reverse(linkedList);
        printList(reverse);
    }
}
