package sedgewick.basic.problems.general;

import java.util.List;

/**
 * Remove Duplicates from a sorted list using BinarySearch
 */
public final class RemoveDuplicates {

    private static boolean match(List<Integer> intList, final int startIndex, final int key) {
        int high = intList.size();
        int low = startIndex;

        int mid;

        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(key == intList.get(mid))
                return true;

            // key is smaller than the mid element of the list
            if(intList.get(mid) > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static List<Integer> removeDuplicates(List<Integer> intList) {
        int index = 1;
        while(index < intList.size()) {
            if(match(intList, index, intList.get(index - 1))) {
                intList.remove(intList.get(index));
            } else {
                ++index;
            }
        }
        return intList;
    }
}
