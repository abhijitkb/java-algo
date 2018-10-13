package sedgewick.basic.problems.general;

import java.util.Arrays;

public class StaticSetOfInts {
    private int [] keys;

    public StaticSetOfInts(int [] keys) {
        this.keys = new int[keys.length];
        System.arraycopy(keys, 0, this.keys, 0, keys.length);
        Arrays.sort(this.keys);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        int low = 0;
        int high = this.keys.length - 1;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) >> 1);

            if(key < this.keys[mid])
                high = mid - 1;
            else if(key > this.keys[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public int lowerBound(int key) {
        int low = 0;
        int high = this.keys.length - 1;
        int mid;
        int diff;
        int index = -1;

        while(low <= high) {
            mid = low + ((high - low) >> 1);
            diff = key - this.keys[mid];
            if(diff > 0) {
                low = mid + 1;
            } else {
                if(diff == 0)
                    index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    public int higherBound(int key) {
        int low = 0;
        int high = this.keys.length - 1;
        int mid;
        int diff;
        int index = -1;


        while(low <= high) {
            mid = low + ((high - low) >> 1);
            diff = key - this.keys[mid];
            if(diff >= 0) {
                if(diff == 0)
                    index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public int howMany(int key) {
        int lowerBound = lowerBound(key);

        if(lowerBound == -1)
            return 0;

        int higherBound = higherBound(key);

        return higherBound - lowerBound + 1;
    }

}
