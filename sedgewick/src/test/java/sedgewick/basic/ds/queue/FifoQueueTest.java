package sedgewick.basic.ds.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FifoQueueTest {
    FifoQueue<String> fifoQueue;

    @BeforeEach
    void setup() {
        fifoQueue = new FifoQueue<>();
    }

    @Test
    void testEnque() {
        fifoQueue.enqueue("Hello");
        fifoQueue.enqueue("World");
        fifoQueue.forEach(System.out::println);

        Assertions.assertEquals(2, fifoQueue.size());
    }

    @Test
    void testDeque() {
        fifoQueue.enqueue("Hello");
        fifoQueue.enqueue("World");

        Assertions.assertEquals(2, fifoQueue.size());
        Assertions.assertEquals("Hello", fifoQueue.dequeue());
        Assertions.assertEquals(1, fifoQueue.size());

        fifoQueue.forEach(System.out::println);
    }

}