package sedgewick.basic.problems.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatrascuBinarySearchTest {

    @Test
    void fibonacciSearch() {
        Integer [] numbers = { 10, 22, 30, 44, 56, 58, 60, 70, 100, 110, 120 };
        int index = PatrascuBinarySearch.fibonacciSearch(numbers, 60, Integer::compare);
        assertEquals(6, index);

        index = PatrascuBinarySearch.fibonacciSearch(numbers, 10, Integer::compare);
        assertEquals(0, index);

        index = PatrascuBinarySearch.fibonacciSearch(numbers, 10, Integer::compare);
        assertEquals(0, index);

        numbers = new Integer[] { 10 };
        index = PatrascuBinarySearch.fibonacciSearch(numbers, 10, Integer::compare);
        assertEquals(0, index);

    }
}