package sedgewick.basic.problems.general;

import java.util.Objects;

/**
 * Write a program that, given two sorted arrays of N int values, prints all elements that appear in both arrays, in sorted order. The running time of your program
 * should be proportional to N in the worst case.
 */
public class PrintSortedArrays {
    public static String printSorted(int [] array1, int [] array2) {
        Objects.requireNonNull(array1);
        Objects.requireNonNull(array2);

        StringBuilder builder = new StringBuilder();

        int i = 0;
        int j = 0;
        while((i < array1.length) && (j < array2.length)) {
            int value = (array1[i] < array2[j]) ?  array1[i++] : array2[j++];
            builder.append(String.format("%d ", value));
        }
        while(i < array1.length) {
            builder.append(String.format("%d ", array1[i++]));
        }

        while(j < array2.length) {
            builder.append(String.format("%d ", array2[j++]));
        }

        return builder.toString();
    }
}
