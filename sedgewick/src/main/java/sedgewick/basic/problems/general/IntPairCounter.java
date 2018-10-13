package sedgewick.basic.problems.general;

import java.util.Arrays;

public class IntPairCounter {

    private static int binarySearch(int [] input, int low, int high, int value) {
        int mid;
        while(low <= high) {
            mid = (low + (high - low)) >> 1;

            if(value == input[mid])
                return mid;

            if(value < input[mid]) {
                high = mid - 1;
            } else if (value > input[mid]) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int numPairs(int [] input) {
        int count = 0;
        Arrays.sort(input);

        for(int i = 0; i < input.length; ++i) {
            if(binarySearch(input, i + 1, input.length - 1, input[i]) > i)
                ++count;
        }

        return count;
    }
}
