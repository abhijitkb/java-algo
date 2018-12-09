package sedgewick.basic.problems.steque;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StequeUsingQueueTest {
    @Test
    void testEmptySteque() {
        StequeUsingQueue<Integer> steque = new StequeUsingQueue<>();
        assertThrows(NoSuchElementException.class, steque::top);
        assertThrows(NoSuchElementException.class, steque::pop);
        assertEquals(0, steque.size());
    }

    @Test
    void testOnePushEnqueuPopTopSteque() {
        StequeUsingQueue<Integer> steque = new StequeUsingQueue<>();
        assertEquals(0, steque.size());

        // Push
        steque.push(10);
        assertEquals(Integer.valueOf(10), steque.top());
        assertEquals(1, steque.size());
        assertEquals(Integer.valueOf(10), steque.pop());
        assertEquals(0, steque.size());
        // Enqueue
        steque.enqueue(10);
        assertEquals(Integer.valueOf(10), steque.top());
        assertEquals(1, steque.size());
        assertEquals(Integer.valueOf(10), steque.pop());
        assertEquals(0, steque.size());
    }

    @Test
    void testPushEnqueue() {
        StequeUsingQueue<Integer> steque = new StequeUsingQueue<>();
        assertEquals(0, steque.size());

        // Push
        steque.push(10);
        assertEquals(Integer.valueOf(10), steque.top());
        assertEquals(1, steque.size());
        // Enqueue
        steque.enqueue(100);
        assertEquals(Integer.valueOf(10), steque.top());
        assertEquals(2, steque.size());

        assertEquals(Integer.valueOf(10), steque.pop());
        assertEquals(1, steque.size());

        assertEquals(Integer.valueOf(100), steque.pop());
        assertEquals(0, steque.size());
    }
}