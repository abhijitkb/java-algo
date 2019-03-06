package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowerBoundTest {
    @Test
    void testDuplicates() {
        int [] values = {1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6};
        assertEquals(2, LowerBound.lowerBouned(values, 3));
    }

    @Test
    void testKeyAtEnd() {
        int [] values = {1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6};
        assertEquals(11, LowerBound.lowerBouned(values, 6));
    }

    @Test
    void testKeyAtStart() {
        int [] values = {1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6};
        assertEquals(0, LowerBound.lowerBouned(values, 1));
    }


    @Test
    void testNegative() {
        int [] values = {1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6};
        assertEquals(-1, LowerBound.lowerBouned(values, 10));
    }

}