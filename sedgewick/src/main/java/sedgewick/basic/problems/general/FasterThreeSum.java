package sedgewick.basic.problems.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a Three Sum that takes quadratic time
 */
public class FasterThreeSum {
    public static List<int[]> threeSums(int[] numbers) {
        List<int[]> triples = new ArrayList<>();

        for (int i = 0; i < numbers.length - 3; i++) {
            // skip the duplicates
            if((i != 0) && numbers[i - 1] == numbers[i])
                continue;

            int start = i + 1;
            int end = numbers.length - 1;

            int sum;
            while(start < end) {
                sum = numbers[start] + numbers[end];
                if(sum == -numbers[i]) {
                    triples.add(new int[] { numbers[i], numbers[start++], numbers[end--] });
                } else if(sum > -numbers[i]) {
                    // handle duplicates
                    while(numbers[end] == numbers[--end])
                        --end;
                } else {
                    // handle duplicates
                    while(numbers[start] == numbers[++start])
                        ++start;
                }
            }
        }
        return triples;
    }
}
