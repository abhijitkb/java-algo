package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FasterThreeSumTest {
    @Test
    void testSample1() {
        int [] values = { -4, -1, -1, -1, 0, 1, 2, 2 };
        List<?> result = FasterThreeSum.threeSums(values);
        assertEquals(4, result.size());
    }

}