package sedgewick.basic.problems.memoisation.memoisation;

/**
 * Problem 1.1.19 Efficient Fibonacci Series
 */
public final class Fibonacci {
    public static final int MAX_FIBONACCI_NUMBER = 50;
    private static long[] fibonacciValues = new long[MAX_FIBONACCI_NUMBER + 1];

    public static long fibonacci(int number) throws UnsupportedOperationException {
        if(number > MAX_FIBONACCI_NUMBER)
            throw new UnsupportedOperationException(String.format("Till %d is supported", MAX_FIBONACCI_NUMBER));

        if(number == 0)
            return 1;
        if(number == 1)
            return 1;

        if(fibonacciValues[number] == 0)
            fibonacciValues[number] = fibonacci(number - 1) + fibonacci(number - 2);
        return fibonacciValues[number];
    }
}
