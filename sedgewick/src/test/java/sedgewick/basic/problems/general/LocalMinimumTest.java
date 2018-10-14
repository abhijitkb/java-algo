package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalMinimumTest {

    @Test
    void testLocalMin() {
        int [] values = {4, 3, 1, 14, 16, 40};
        Assertions.assertEquals(2, LocalMinimum.localMin(values));
    }


    @Test
    void testLocalMinNegative() {
        int [] values = {4, 3, 7, 14, 16, 40};
        Assertions.assertEquals(-1, LocalMinimum.localMin(values));
    }
}