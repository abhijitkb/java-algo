package sedgewick.basic.ds.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LinkedGeneralisedQueueTest {
    private LinkedGeneralisedQueue<Integer> queue;

    @BeforeEach
    void setup() {
        queue = new LinkedGeneralisedQueue<>();
    }

    @Test
    void testEnqueueDequeue() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(queue::enqueue);

        values.forEach(
                value -> {
                    Assertions.assertEquals(value, queue.dequeue());
                }
        );
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueueDequeueN() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(queue::enqueue);

        Assertions.assertEquals(2, queue.dequeue(2).intValue());
        Assertions.assertEquals(3, queue.size());
    }
}