package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Test;
import sedgewick.basic.ds.stack.Stack;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StackUsingQueueTest {
    @Test
    void testEmptyPop() {
        Stack<Integer> stack = new StackUsingQueue<>();
        assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    void testStackOperations() {
        Stack<Integer> stack = new StackUsingQueue<>();

        Integer [] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        for(Integer i : numbers) {
            stack.push(i);
        }

        assertEquals(numbers.length, stack.size());

        List<Integer> actual = new ArrayList<>();
        while(!stack.isEmpty()) {
            actual.add(stack.pop());
        }

        actual.sort(Integer::compareTo);

        List<Integer> expected = new ArrayList<>(Arrays.asList(numbers));
        assertEquals(expected, actual);
    }
}