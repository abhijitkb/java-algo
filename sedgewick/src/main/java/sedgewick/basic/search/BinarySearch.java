package sedgewick.basic.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public final class BinarySearch {
    /**
     * Searches for a given element in a given array; Worst case is O(log n).
     * @param array The input array. <pre>The array should always be sorted</pre>
     * @param element The element that is searched for inside {@code array}
     * @return index of the element found; else -1 when no match
     */
    public static <T> int search(@NotNull final T [] array, @NotNull final T element, final Comparator<T> comparator) {
        int low = 0;
        int high = array.length;

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            int diff = comparator.compare(array[mid], element);

            if(diff < 0) {
                high = mid - 1;
            } else if(diff > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1; // not found
    }

    public static <T> int searchMinIndex(@NotNull final T [] array, @NotNull final T element, @NotNull final Comparator<T> comparator) {
        int low = 0;
        int high = array.length;
        int indexFound = -1;

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            int diff = comparator.compare(array[mid], element);

            if(diff > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
                if (diff == 0)
                    indexFound = mid;
            }
        }

        return indexFound;
    }
}
