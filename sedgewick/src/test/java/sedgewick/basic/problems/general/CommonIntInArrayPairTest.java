package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class CommonIntInArrayPairTest {
    @Test
    void testPrintCommon() {
        int [] first = {1, 2, 3, 4, 5, 6, 7};
        int [] second = {2, 2, 3, 4, 7, 7, 8};

        Collection<Integer> result = CommonIntInArrayPair.getCommonIntegers(first, second);
        int [] expectedValues = {2, 3, 4, 7};
        ArrayList<Integer> expected = new ArrayList<>();
        for(int i : expectedValues)
            expected.add(i);

        Assertions.assertEquals(expected, result);

    }

}