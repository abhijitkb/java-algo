package sedgewick.basic.ds.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> doublyLinkedList;

    @BeforeEach
    void setupLinkedList() {
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    void testAppendOne() {
        doublyLinkedList.append(1);
        Assertions.assertEquals(1, doublyLinkedList.find(1).value.intValue());
    }

    @Test
    void testAppendThree() {
        List<Integer> values = Arrays.asList(1, 2, 3);
        values.forEach(doublyLinkedList::append);

        values.forEach(value -> {
            DoublyLinkedList.Node<Integer> node = doublyLinkedList.find(value);
            Assertions.assertTrue(node != null);
        });
    }

    @Test
    void testRemoveNode() {
        List<Integer> values = Arrays.asList(1, 2, 3);
        values.forEach(doublyLinkedList::append);

        values.forEach(value -> {
            DoublyLinkedList.Node<Integer> node = doublyLinkedList.remove(value);
            Assertions.assertTrue(node != null);
        });

        Assertions.assertTrue(doublyLinkedList.isEmpty());
    }
}