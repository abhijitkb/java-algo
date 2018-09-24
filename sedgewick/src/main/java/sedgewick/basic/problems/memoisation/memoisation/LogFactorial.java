package sedgewick.basic.problems.memoisation.memoisation;

/**
 * 1.1.20 Problem : ln(N!)  => Natural log of factorial N
 */
public class LogFactorial {
    public static final int MAX_SIZE = 50;
    private static long[] factorials = new long[MAX_SIZE + 1];
    private static double[] lnFactorials = new double[MAX_SIZE + 1];

    private static long factorial(final int number) {
        if((number == 0) || (number == 1))
            return 1;

        if(factorials[number] == 0)
            factorials[number] = number * factorial(number - 1);
        return factorials[number];
    }

    public static double  lnFactorial(final int number) {
        if(number < 1)
            throw new IllegalArgumentException(String.format("number has to be integral values greater than 0"));

        if(number == 1)
            return 0;

        if(lnFactorials[number] == 0) {
            long factorial = factorial(number);
            lnFactorials[number] = Math.log(factorial);
        }

        return lnFactorials[number];
    }
}
