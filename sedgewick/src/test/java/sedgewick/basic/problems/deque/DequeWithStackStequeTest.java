package sedgewick.basic.problems.deque;

import org.junit.jupiter.api.Test;
import sedgewick.basic.ds.deque.Deque;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DequeWithStackStequeTest {
    @Test
    void testEmptyDeque() {
        Deque<Integer> deque = new DequeWithStackSteque<>();
        assertThrows(NoSuchElementException.class, deque::popLeft);
        assertThrows(NoSuchElementException.class, deque::popRight);
    }

    @Test
    void testOnePushEnqueuPop() {
        Deque<Integer> deque = new DequeWithStackSteque<>();
        assertEquals(0, deque.size());

        // Push
        deque.pushLeft(10);
        assertEquals(1, deque.size());
        assertEquals(Integer.valueOf(10), deque.popLeft());
        deque.pushLeft(10);
        assertEquals(Integer.valueOf(10), deque.popRight());
        assertEquals(0, deque.size());

        // Enqueue
        deque.pushRight(10);
        assertEquals(1, deque.size());
        assertEquals(Integer.valueOf(10), deque.popLeft());
        deque.pushRight(10);
        assertEquals(Integer.valueOf(10), deque.popRight());
        assertEquals(0, deque.size());
    }

    @Test
    void testPushEnqueue() {
        Deque<Integer> deque = new DequeWithStackSteque<>();
        deque.pushLeft(1);
        deque.pushRight(2);
        deque.pushLeft(3);
        deque.pushRight(4);

        assertEquals(Integer.valueOf(3), deque.head());
        assertEquals(Integer.valueOf(4), deque.tail());
        assertEquals(4, deque.size());

        assertEquals(Integer.valueOf(3), deque.popLeft());
        assertEquals(Integer.valueOf(1), deque.head());
        assertEquals(Integer.valueOf(4), deque.tail());
        assertEquals(3, deque.size());

        assertEquals(Integer.valueOf(4), deque.popRight());
        assertEquals(Integer.valueOf(1), deque.head());
        assertEquals(Integer.valueOf(2), deque.tail());
        assertEquals(2, deque.size());

        assertEquals(Integer.valueOf(2), deque.popRight());
        assertEquals(Integer.valueOf(1), deque.head());
        assertEquals(Integer.valueOf(1), deque.tail());
        assertEquals(1, deque.size());
    }
}