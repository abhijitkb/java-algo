package sedgewick.basic.problems.general;

/**
 *  The {@code Accumulator} class is a data type for computing the running
 *  mean, sample standard deviation, and sample variance of a stream of real
 *  numbers. It provides an example of a mutable data type and a streaming
 *  algorithm.
 *  <p>
 *  This implementation uses a one-pass algorithm that is less susceptible
 *  to floating-point roundoff error than the more straightforward
 *  implementation based on saving the sum of the squares of the numbers.
 *  This technique is due to
 *  <a href = "https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Online_algorithm">B. P. Welford</a>.
 *  Each operation takes constant time in the worst case.
 *  The amount of memory is constant - the data values are not stored.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */public class Accumulator {
    private double mean;
    private double squaredStddev;
    private int numbers;

    public void addDataValue(double x) {
        ++numbers;
        squaredStddev = squaredStddev + 1.0 * (numbers - 1)/numbers * (x - mean) * (x - mean);
        mean = mean + (x - mean)/numbers;
    }

    public double mean() {
        return mean;
    }

    public double variance() {
        return squaredStddev / (numbers - 1);
    }

    public double stddev() {
        return Math.sqrt(this.variance());
    }

    public int count() {
        return numbers;
    }
}
