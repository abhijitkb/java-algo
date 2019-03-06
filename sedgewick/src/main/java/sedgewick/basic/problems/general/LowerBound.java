package sedgewick.basic.problems.general;

import java.util.Objects;

/**
 * Binary Search that always returns the element with the smallest index but still has logarithmic running time
 */
public class LowerBound {
    public static int lowerBouned(int [] values, int key) {
        Objects.requireNonNull(values);
        if(values.length == 0)
            throw new IllegalArgumentException("The values sorted array must have at least one element");

        int low = 0;
        int high = values.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(key > values[mid]) {
                low = mid + 1;
            } else {
                if(key == values[mid])
                    foundIndex = mid;
                high = mid - 1;
            }
        }
        return foundIndex;
    }
}
