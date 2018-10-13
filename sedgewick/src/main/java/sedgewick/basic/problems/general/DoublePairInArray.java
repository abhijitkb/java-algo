package sedgewick.basic.problems.general;

import java.util.Arrays;
import java.util.Comparator;

public class DoublePairInArray {
    public static class Pair {
        public double first;
        public double second;

        public Pair(final double first, final double second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * Given an array a[] of N double values, finds a closest pair : two values whose difference is no greater than the
     * the difference of any other pair (in absolute value).
     * Worse Case Running Time: linearithmic
     */
    public static Pair getClosestPair(final double [] values) {
        Arrays.sort(values);
        Pair pair = new Pair(values[0], values[1]);
        double minDiff = Math.abs(values[1] - values[0]);
        double diff;
        for(int i = 1; i < values.length - 1; ++i) {
            diff = Math.abs(values[i] - values[i + 1]);
            if(Double.compare(diff, minDiff) < 0) {
                minDiff = diff;
                pair.first = values[i];
                pair.second = values[i + 1];
            }
        }

        return pair;
    }

    /**
     * Given an array a[] of N double values, finds a closest pair : two values whose difference is no smaller than the
     * the difference of any other pair (in absolute value).
     * Worse Case Running Time: linear
     */
    public static Pair getFarthestPair(final double [] values) {
        Arrays.sort(values);
        return new Pair(values[0], values[values.length - 1]);
    }
}
