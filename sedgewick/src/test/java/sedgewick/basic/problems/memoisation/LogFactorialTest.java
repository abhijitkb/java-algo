package sedgewick.basic.problems.memoisation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sedgewick.basic.problems.memoisation.memoisation.LogFactorial;


class LogFactorialTest {

    private void testLogOfFactorial(final int number, final double expected) {
        Assertions.assertEquals(expected, LogFactorial.lnFactorial(number), 0.00001);
    }

    @Test
    void testLogFactorial_6() {
        testLogOfFactorial(6, 6.57925121201);
    }

    @Test
    void testLogFactorial_1() {
        testLogOfFactorial(1, 0.0);
    }

    @Test
    void testLogFactorial_exception() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> LogFactorial.lnFactorial(LogFactorial.MAX_SIZE + 1));
    }

    @Test
    void testLogFactorial_max() {
        testLogOfFactorial(20, 42.3356164607);
    }

}