package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintSortedArraysTest {
    @Test
    void testSortedArrays() {
        int [] values1 = { 1, 2, 3, 4, 6, 7, 8, 10, 10, 13, 18 };
        int [] values2 = { 0, 5, 9, 11, 12, 14, 15 };

        assertEquals("0 1 2 3 4 5 6 7 8 9 10 10 11 12 13 14 15 18 ", PrintSortedArrays.printSorted(values1, values2));
    }
}