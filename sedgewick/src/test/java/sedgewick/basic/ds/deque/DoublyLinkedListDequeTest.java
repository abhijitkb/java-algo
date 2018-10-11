package sedgewick.basic.ds.deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DoublyLinkedListDequeTest {
    private DoublyLinkedListDeque<Integer> deque;

    @BeforeEach
    void setup() {
        deque = new DoublyLinkedListDeque<>();
    }

    @Test
    void testLeftPushesPopRight() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(deque::pushLeft);
        Assertions.assertEquals(values.size(), deque.size());
        values.forEach(
                value -> {
                    Assertions.assertEquals(value, deque.popRight());
                }
        );
    }

    @Test
    void testPushesRightPopLeft() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(deque::pushRight);
        Assertions.assertEquals(values.size(), deque.size());
        values.forEach(
                value -> {
                    Assertions.assertEquals(value, deque.popLeft());
                }
        );
    }

    @Test
    void testPushesRightPopRight() {
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        values.forEach(deque::pushRight);
        Assertions.assertEquals(values.size(), deque.size());
        Collections.reverse(values);
        values.forEach(
                value -> {
                    Assertions.assertEquals(value, deque.popRight());
                }
        );
    }

    @Test
    void testPushesLeftPopLeft() {
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        values.forEach(deque::pushLeft);
        Assertions.assertEquals(values.size(), deque.size());
        Collections.reverse(values);
        values.forEach(
                value -> {
                    Assertions.assertEquals(value, deque.popLeft());
                }
        );
    }
}