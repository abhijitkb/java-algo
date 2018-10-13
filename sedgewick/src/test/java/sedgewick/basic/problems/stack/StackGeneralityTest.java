package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StackGeneralityTest {

    @Test
    void testSequence1() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = Arrays.asList(4, 5, 3, 2, 1);

        Assertions.assertTrue(StackGenerality.canMatchOutputUnique(input, output));
    }

    @Test
    void testSequence2() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = Arrays.asList(4, 3, 5, 1, 2);

        Assertions.assertFalse(StackGenerality.canMatchOutputUnique(input, output));
    }

    @Test
    void testSequence3() {
        List<Integer> input = Arrays.asList(1, 4, 3, 4, 5);
        List<Integer> output = Arrays.asList(4, 5, 3, 4, 1);

        Assertions.assertFalse(StackGenerality.canMatchOutputUnique(input, output));
    }

}