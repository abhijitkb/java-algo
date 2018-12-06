package sedgewick.basic.problems.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

/**
 * {@link PatrascuBinarySearch} Binary Search with only addition and substraction.
 * <p>
 *     <lu>
 *         <li>Operations: Additions and Substractions</li>
 *         <li>Pre Condition: Array in ascending order (Natural Ordering) </li>
 *         <li>Constraints: No additional memory</li>
 *         <li>Worst case running time: log N</li>
 *     </lu>
 *
 * </p>
 */
public final class PatrascuBinarySearch {
    static <T> int naiveFibonacciSearch(@NotNull final T[] array, final T key, Comparator<? super T> comparator) {
        int index = 0;
        int curFibNum = 0;
        int nextFibNum = 1;

        int low = 0;
        int high = array.length - 1;

        int lastIndex;
        boolean resetRange = false;

        while(low <= high) {
            // setup index with current Fibonacci seq number
            index += curFibNum;

            // reset Fibonacci sequences if current index is out of range
            if(index > high)
                resetRange = true;

            if(resetRange) {
                curFibNum = 0;
                nextFibNum = 1;
                index = low; // the first element will always be visited in a Fibonacci sequence
            }

            // check for match
            int diff = Objects.compare(array[index], key, comparator);
            if(diff == 0) {
                return index;
            }

            // save the current index
            lastIndex = index;

            // leap forward iff key is greater than current indexed element
            if(diff > 0) {
                curFibNum += nextFibNum;
                nextFibNum += curFibNum;
            } else { // need to hop back and narrow range
                resetRange = true;
                low = lastIndex + 1;
                high = index - 1;
            }
        }

        return -1;
    }

    public static <T> int fibonacciSearch(@NotNull final T[] array, final T key, Comparator<? super T> comparator) {
        int fibN = 0;  // the pivot index
        int fibN1 = 1;
        int fibN2 = fibN + fibN1;  // ceiling

        while(fibN2 < array.length) {
            fibN = fibN1;
            fibN1 = fibN2;
            fibN2 = fibN + fibN1;
        }

        int offset = -1; // -1 is to adjust the 1-based matching (fibN1 has a min value of 1)
        final int high = array.length - 1;

        while(fibN2 > 1) {
            // ensure that we are working on a valid location
            int i = Math.min(fibN + offset, high);

            int diff = Objects.compare(array[i], key, comparator);

            if(diff < 0) {
                // key is greater than current pivot ... pivot => fibN
                fibN2 = fibN1;
                fibN1 = fibN;
                fibN = fibN2 - fibN1;

                offset = i; // discard all elements prior to index "i"
            } else if(diff > 0) {
                // current pivot is greater than key ... leap to the left by the last Fibonacci index
                fibN2 = fibN;
                fibN1 -= fibN;
                fibN = fibN2 - fibN1;
            } else {
                // voila ... match found
                return i;
            }
        }

        // only one element is remaining .. check for a match
        if( (fibN1 == 1) && (Objects.compare(array[offset + 1], key, comparator) == 0))
            return offset + 1;

        // no matches found!
        return -1;
    }

    private static int nearestFibonacciNumber(final int number) {
        assert number >= 0 : "number must be a Whole Integer";

        int curFib = 0;
        int nextFib = 1;

        while(nextFib <= number) {
            if(curFib == number)
                break;
            curFib += nextFib;
            nextFib += curFib;
        }

        return curFib;
    }
}
