package sedgewick.basic.problems.general;

import java.util.Arrays;

/**
 * Find the number of doubles which add up to ZERO for a given list of integers
 */
public class TwoSum {
    static class LowerBound {
        static int search(int[] integers, int start, int end, int value) {
            int mid ;
            int index = -1;

            while(start <= end) {
                mid = start + ((start + end) >> 1);
                if(integers[mid] == value)
                    return mid;

                if(integers[mid] > value)
                    start = mid + 1;
                else if(integers[mid] < value)
                    end = mid - 1;
            }
            return -1;  // none found
        }
    }

    public static int twoSum(int[] numbers) {
        Arrays.sort(numbers);

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(LowerBound.search(numbers, i + 1, numbers.length - 1, -numbers[i]) > -1)
                ++count;
        }
        return count;
    }
}
