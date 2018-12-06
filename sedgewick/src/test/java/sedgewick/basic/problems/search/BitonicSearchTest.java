package sedgewick.basic.problems.search;

import org.junit.jupiter.api.Test;
import sedgewick.basic.problems.search.BitonicSearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitonicSearchTest {

    @Test
    void testBitonicParition() {
        int [] numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        int bitonicIndex = BitonicSearch.bitonicParition(numbers);
        assertEquals(bitonicIndex, 4);

        numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8, 5, 4, 2};
        bitonicIndex = BitonicSearch.bitonicParition(numbers);
        assertEquals(bitonicIndex, 4);

        numbers = new int [] { 3, 5, 7, 9, 15, 12};
        bitonicIndex = BitonicSearch.bitonicParition(numbers);
        assertEquals(bitonicIndex, 4);

        numbers = new int [] { 9, 15, 12, 11, 8, 5, 4, 2};
        bitonicIndex = BitonicSearch.bitonicParition(numbers);
        assertEquals(bitonicIndex, 1);
    }

    @Test
    void testBitonicSearch() {
        int [] numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        int index = BitonicSearch.bitonicSearch(numbers, 7);
        assertEquals(2, index);

        numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        index = BitonicSearch.bitonicSearch(numbers, 8);
        assertEquals(7, index);

        numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        index = BitonicSearch.bitonicSearch(numbers, 3);
        assertEquals(0, index);

        numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        index = BitonicSearch.bitonicSearch(numbers, 1);
        assertTrue(index < 0);
    }

    @Test
    void testOptimisedBitonicSearch() {
        int [] numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        int index = BitonicSearch.bitonicSearch(numbers, 7);
        assertEquals(2, index);

        numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        index = BitonicSearch.bitonicSearch(numbers, 8);
        assertEquals(7, index);

        numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        index = BitonicSearch.bitonicSearch(numbers, 3);
        assertEquals(0, index);

        numbers = new int [] { 3, 5, 7, 9, 15, 12, 11, 8};
        index = BitonicSearch.bitonicSearch(numbers, 1);
        assertTrue(index < 0);
    }
}