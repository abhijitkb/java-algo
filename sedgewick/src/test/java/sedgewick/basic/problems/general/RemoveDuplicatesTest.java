package sedgewick.basic.problems.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RemoveDuplicatesTest {

    @Test
    void testDuplicate_1duplicate_2elements() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(1);

        Assertions.assertEquals(1, RemoveDuplicates.removeDuplicates(intList).size());
    }

    @Test
    void testDuplicate_empty() {
        List<Integer> intList = new ArrayList<>();

        Assertions.assertEquals(0, RemoveDuplicates.removeDuplicates(intList).size());
    }

    @Test
    void testDuplicate_unique() {
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
            intList.add(i);

        Assertions.assertEquals(4, RemoveDuplicates.removeDuplicates(intList).size());
    }


    @Test
    void testDuplicate_allDuplicates() {
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
            intList.add(1);

        Assertions.assertEquals(1, RemoveDuplicates.removeDuplicates(intList).size());
    }

    @Test
    void testDuplicate_halfDuplicates() {
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < 10; ++i) {
            if( i % 2 == 0)
                intList.add(1);
            else
                intList.add(i * 10);
        }

        Collections.sort(intList);
        System.out.println(intList);

        List<Integer> updatedList = RemoveDuplicates.removeDuplicates(intList);
        System.out.println(updatedList);
        Assertions.assertEquals(6, updatedList.size());
    }
}