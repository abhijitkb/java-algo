package sedgewick.basic.ds.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {
    private CircularLinkedList<Integer> circularLinkedList;

    @BeforeEach
    void setup() {
        circularLinkedList = new CircularLinkedList<>();
    }

    @Test
    void testAdd() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(circularLinkedList::add);

        values.forEach( value -> Assertions.assertTrue(circularLinkedList.find(value)));
    }

    @Test
    void testInsertAfterRemoveAfter() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(circularLinkedList::add);

        circularLinkedList.insertAfter(2, 10);
        CircularLinkedList.Node<Integer> node = circularLinkedList.removeAfter(circularLinkedList.findNode(2));

        Assertions.assertEquals(10, node.value.intValue());
    }

    @Test
    void testRemove() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(circularLinkedList::add);

        values.forEach(circularLinkedList::remove);

        Assertions.assertTrue(circularLinkedList.isEmpty());
    }
}