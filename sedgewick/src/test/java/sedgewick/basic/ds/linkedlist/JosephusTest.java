package sedgewick.basic.ds.linkedlist;

import org.junit.jupiter.api.Test;
import sedgewick.basic.problems.linkedlist.Josephus;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JosephusTest {
    @Test
    void testSampleJosephusProblem() {
        Josephus josephus = new Josephus(7, 2);
        Collection<Integer> eliminationPosition = josephus.showEliminations();
        List<Integer> expected = Arrays.asList(1, 3, 5, 0, 4, 2, 6);
        assertEquals(expected, eliminationPosition);
    }
}