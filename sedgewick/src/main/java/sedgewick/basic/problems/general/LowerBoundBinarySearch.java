package sedgewick.basic.problems.general;

public class LowerBoundBinarySearch {

    public static <T extends Comparable<T>> int binarySearch(T [] input, int low, int high, final T value) {
        int index = -1;
        int mid;
        int comparision;
        while(low <= high) {
            mid = low + ((high - low) >> 1);
            comparision = value.compareTo(input[mid]);

            if(comparision > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
                if(comparision == 0)
                    index = mid;
            }
        }

        return index;
    }
}
