package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclidGcdTest {
    @Test
    void testEuclidGcd_1() {
        Assertions.assertEquals(1, EuclidGcd.gcd(1111111, 1234567));
    }


    @Test
    void testEuclidGcd_12() {
        Assertions.assertEquals(12, EuclidGcd.gcd(24, 36));
    }
}