package sedgewick.basic.problems.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Print all elements that appear in both arrays (in sorted order). The running time of the program
 * should be proportional to N in the worst case.
 */
public class CommonIntInArrayPair {

    public static Collection<Integer> getCommonIntegers(final int [] first, final int [] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        assert first.length == second.length : "Both arrays should be of same length";

        ArrayList<Integer> results = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;
        int diff;

        while((firstIndex < first.length) && (secondIndex < second.length)) {
            diff = first[firstIndex] - second[secondIndex];

            if(diff < 0) { // first's element is smaller
                ++firstIndex;
            } else if(diff > 0) {
                ++secondIndex; // second's element is smaller
            } else {
                results.add(first[firstIndex]);
                firstIndex++;
                secondIndex++;
            }
        }

        return results;
    }
}
