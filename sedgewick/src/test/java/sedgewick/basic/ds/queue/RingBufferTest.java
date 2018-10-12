package sedgewick.basic.ds.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferTest {
    private RingBuffer<Integer> ringBuffer;

    @BeforeEach
    void setup() {
        this.ringBuffer = new RingBuffer<>(new Integer[0], 4);
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(ringBuffer.isEmpty());
    }

    @Test
    void testFailIsFull() {
        Assertions.assertFalse(ringBuffer.isFull());
    }

    @Test
    void testOfferClaimOne() {
        this.ringBuffer.offer(1);
        Assertions.assertEquals(1, this.ringBuffer.size());
        Assertions.assertEquals(1, this.ringBuffer.claim().intValue());
        Assertions.assertTrue(this.ringBuffer.isEmpty());
    }

    @Test
    void testOfferFull() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(this.ringBuffer::offer);
        Assertions.assertTrue(this.ringBuffer.isFull());
        Assertions.assertFalse(this.ringBuffer.offer(4));
        list.forEach(
                value -> Assertions.assertEquals(value, this.ringBuffer.claim())
        );
        Assertions.assertEquals(null, this.ringBuffer.claim());
    }

}