package sedgewick.basic.problems.memoisation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sedgewick.basic.problems.memoisation.memoisation.Fibonacci;

class FibonacciTest {
    private void testFibonacci(final int number, final long expected) {
        final long result = Fibonacci.fibonacci(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFibonacci_0() {
        testFibonacci(0, 1);
    }

    @Test
    void testFibonacci_1() {
        testFibonacci(1, 1);
    }

    @Test
    void testFibonacci_20() {
        testFibonacci(20, 10946L);
    }

    @Test
    void testFibonacci_30() {
        testFibonacci(30, 1346269L);
    }

    @Test
    void testFibonacci_40() {
        testFibonacci(40, 165580141L);
    }

    @Test
    void testFibonacci_45() {
        testFibonacci(45, 1836311903L);
    }

    @Test
    void testFibonacci_max() {
        testFibonacci(Fibonacci.MAX_FIBONACCI_NUMBER, 20365011074L);
    }


    @Test
    void testFibonacciException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> Fibonacci.fibonacci(Fibonacci.MAX_FIBONACCI_NUMBER + 1));
    }
}