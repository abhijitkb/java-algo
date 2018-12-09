package sedgewick.basic.problems.steque;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StequeWithStacksTest {
    @Test
    void testEmptySteque() {
        StequeWithStacks<Integer> steque = new StequeWithStacks<>();
        assertThrows(NoSuchElementException.class, steque::top);
        assertThrows(NoSuchElementException.class, steque::pop);
        assertEquals(0, steque.size());
    }

    @Test
    void testOnePushEnqueuPopTopSteque() {
        StequeWithStacks<Integer> steque = new StequeWithStacks<>();
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
        StequeWithStacks<Integer> steque = new StequeWithStacks<>();
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
    }}