package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarthestPairTest {

    @Test
    void getFarthestPair() {
        double [] points = {1, 2, 3, 4, 5, 5.5, 6.25, 7, 8};
        DistancePair.Pair pair = DistancePair.getFarthestPair(points);
        DistancePair.Pair expected = new DistancePair.Pair(1, 8);
        assertEquals(expected, pair);
    }
}