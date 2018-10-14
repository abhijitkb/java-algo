package sedgewick.basic.problems.general;

import java.util.Arrays;

/**
 * Given an array a[] of N distinct integers,
 * finds a local minimum: an index i such that a[i-1] < a[i] < a[i+1].
 * Program should use ~2lg N compares in the worst case...
 */
public class LocalMinimum {
    public static int localMin(final int [] values) {
        assert values.length >= 3 : "The input array should have at least 3 elements";

        int low = 0;
        int high = values.length - 1;
        int mid = 0;

        int leftDiff;
        int rightDiff;

        // Loop only till there are at least 1 element between high and low
        while((high - low) > 1) {
            mid = low + ((high - low) >> 1);

            leftDiff = values[mid] - values[mid - 1];
            rightDiff = values[mid] - values[mid + 1];

            if((leftDiff < 0) && (rightDiff < 0))
                return mid;

            if(leftDiff < rightDiff)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
