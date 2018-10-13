package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntPairCounterTest {
    @Test
    void testPairsPositive() {
        int [] input = {1, 5, 32, 12, 5, 6, 12};
        Assertions.assertEquals(2, IntPairCounter.numPairs(input));
    }
}