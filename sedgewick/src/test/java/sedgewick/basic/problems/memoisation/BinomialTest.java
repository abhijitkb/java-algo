package sedgewick.basic.problems.memoisation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinomialTest {

    @Test
    void testBinomial_naive() {
        Assertions.assertEquals(0.05839920, Binomial.binomial_naive(10, 5, 0.25), 0.0000001);
    }

    @Test
    void testBinomial_memoised() {
        Assertions.assertEquals(4.507310875086383E-8, Binomial.binomial_memoised(100, 50, 0.25), 1E-8);
    }
}