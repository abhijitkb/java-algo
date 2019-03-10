package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void getClosestPair() {
        double [] points = {1, 2, 3, 4, 5, 5.5, 6.25, 7, 8};
        DistancePair.Pair pair = DistancePair.getClosestPair(points);
        DistancePair.Pair expected = new DistancePair.Pair(5, 5.5);
        assertEquals(expected, pair);
    }
}