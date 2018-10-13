package sedgewick.basic.problems.general;

import java.util.Arrays;

/**
 * Given an array a[] of N distinct integers,
 * finds a local minimum: an index i such that a[i-1] < a[i] < a[i+1].
 * Program should use ~2lg N compares in the worst case...
 */
public class LocalMinimum {
    public int localMin(final int [] values) {
        assert values.length >= 3 : "The input array should have at least 3 elements";

        int low = 0;
        int high = values.length - 1;
        int mid;

        while(low <= high) {
            mid = low + (high - low) >> 1;
            double diffLeft = values[mid] - values[mid - 1];
            double diffRight = values[mid + 1] - values[mid];

            double compareResult = Double.compare(diffLeft, diffRight);
            if(compareResult == 0)
                return mid;

            if(compareResult < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
