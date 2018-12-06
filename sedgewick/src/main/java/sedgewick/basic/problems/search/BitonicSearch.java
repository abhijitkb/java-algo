package sedgewick.basic.problems.search;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.IntBinaryOperator;

/**
 * Bitonic Array: Sequence of integers followed immediately by a decreasing sequence of integers.
 * <p>
 *     a[N] => bitonic array; mid a the bitonic index such that {@code a[mid] > a[mid - 1] && a[mid] > a[mid + 1] }
 *     Minimal Requirements: Program should use ~lg(N) compares in worst case.
 *     Ideal: ~2lg(N) in worst case
 * </p>
 */
public final class BitonicSearch {
    private static int binarySearch(@NotNull int [] array, final int low, final int high, @NotNull IntBinaryOperator comparator, final int key) {
        int lo = low;
        int hi = high - 1;
        int mid;

        while(lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            int diff = comparator.applyAsInt(array[mid], key);
            if(diff > 0)
                hi = mid - 1;
            else if(diff < 0)
                lo = mid + 1;
            else
                return mid;
        }

        return -1;
    }

    /**
     * Performs a search of an element in a bitonic array.
     * <p>
     *     Worst case: ~3lg(N)
     * </p>
     * @param numbers The integer array <pre>The array must to be {@code bitonic}</pre>
     * @param element The element to be searched inside the array
     * @return Index of the element; -1 if not found
     */
    public static int bitonicSearch(@NotNull final int [] numbers, final int element) {
        assert numbers.length >= 3 : "The minimum number of the array has to be 3 to qualify as a bitonic array";
        int bitonicIndex = bitonicParition(numbers) + 1;
        int mid = binarySearch(numbers, 0, bitonicIndex, (a, b) -> a - b, element);
        if(mid < 0) {
            mid = binarySearch(numbers, bitonicIndex, numbers.length, (a, b) -> b - a, element);
        }
        return mid >= 0 ? mid : -1;
    }

    /**
     * Performs a search of an element in a bitonic array.
     * <p>
     *     Worst case: ~2lg(N)
     * </p>
     * @param numbers The integer array <pre>The array must to be {@code bitonic}</pre>
     * @param element The element to be searched inside the array
     * @return Index of the element; -1 if not found
     */
    public static int optimisedBitonicSearch(@NotNull final int [] numbers, final int element) {
        assert numbers.length >= 3 : "The minimum number of the array has to be 3 to qualify as a bitonic array";
        int bitonicIndex = bitonicParition(numbers) + 1;

        int low, high;
        IntBinaryOperator comparator;

        // check on which series should element lie
        if(numbers[bitonicIndex] <= element) {
            low = bitonicIndex;
            high = numbers.length;
            comparator = (a, b) -> b - a;
        } else {
            low = 0;
            high = bitonicIndex;
            comparator = (a, b) -> a - b;
        }

        return binarySearch(numbers, low, high, comparator, element);
    }

    /**
     * Provides the index position where the descending series starts!
     * @param numbers The integer array <pre>The integer array must be {@code bitonic}</pre>
     * @return Index of the last element of the ascending series.
     * @throws IllegalArgumentException if the array is not bitonic
     */
    static int bitonicParition(@NotNull final int [] numbers) throws IllegalArgumentException {
        int low = 0;
        int high = numbers.length;
        int mid = -1;

        while (low <= high) {
            mid = low + ((high - low) >> 1);

            if(numbers[mid] > numbers[mid - 1]) {
                // we are in ascending series.
                // Is it bitionic?
                if(numbers[mid] > numbers[mid + 1])
                    return mid;

                // move to right to find
                low = mid + 1;
            } else {
                // we are in descending series. Move to left to find the descending series
                high = mid - 1;
            }
        }

        throw new IllegalArgumentException("The input array is not bitonic");
    }
}
