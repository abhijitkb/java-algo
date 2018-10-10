package sedgewick.basic.ds.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StequeTest {
    private Steque<Integer> steque;

    @BeforeEach
    void setupSteque() {
        this.steque = new Steque<>();
    }

    @Test
    void testPushOne() throws IllegalAccessException {
        int value = 10;
        this.steque.push(value);
        Assertions.assertEquals(value, this.steque.top().intValue());
    }


    @Test
    void testPushThree() throws IllegalAccessException {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(this.steque::push);
        for(int i = values.size() - 1; i >= 0; --i) {
            Assertions.assertEquals(values.get(i), this.steque.pop());
        }
        Assertions.assertTrue(this.steque.isEmpty());
    }

    @Test
    void testEnqueueOne() throws IllegalAccessException {
        int value = 10;
        this.steque.enqueue(value);
        Assertions.assertEquals(value, this.steque.top().intValue());
    }

    @Test
    void testEnqueThree() throws IllegalAccessException {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        values.forEach(this.steque::enqueue);
        values.forEach( value -> {
            try {
                Assertions.assertEquals(value, this.steque.pop());
            } catch (IllegalAccessException e) {
                Assertions.fail(e.getMessage());
            }
        });
        Assertions.assertTrue(this.steque.isEmpty());
    }
}