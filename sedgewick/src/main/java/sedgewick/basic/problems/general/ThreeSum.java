package sedgewick.basic.problems.general;

import java.util.Arrays;

/**
 * Implement a quadratic algorithm to count the a 3-set integer sum equaling 0
 */
public class ThreeSum {

    public static int lowerBound(final int [] input, int low, int high, int value) {
        int mid;
        int index = -1;

        while(low <= high) {
            mid = low + (high - low) >> 1;
            if(input[mid] > value) {
                low = mid + 1;
            } else {
                if(input[mid] == value)
                    index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    public static int getThreeSumCount(int [] values) {
        Arrays.sort(values);
        int count = 0;

        for(int i = 0; i < values.length; ++i) {
            for(int j = i + 1; j < values.length; ++j) {
                if(lowerBound(values, j + 1, values.length - 1, -values[i] - values[j]) != -1)
                    ++count;
            }
        }
        return count;
    }
}
