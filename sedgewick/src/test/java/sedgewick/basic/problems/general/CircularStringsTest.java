package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularStringsTest {
    @Test
    void testCircularlyRotatedString() {
        Assertions.assertTrue(CircularStrings.isCircular("TGACGAC", "ACTGACG"));
    }
}