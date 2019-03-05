package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackGeneralityTest {

    @Test
    void testSimplePositiveTestCase() {
        String operations = "1 2 3 4 -4 5 -5 -3 -2 -1";
        assertTrue(StackGenerality.checkStackOperations(operations));
    }

    @Test
    void testSimpleNegativeTestCase() {
        String operations = "1 2 3 4 -4 5 -5 -3 -1 -2";
        assertFalse(StackGenerality.checkStackOperations(operations));
    }

    @Test
    void testPositiveTestCaseWithDuplicates() {
        String operations = "1 4 3 4 -4 5 -5 -3 -4 -1";
        assertTrue(StackGenerality.checkStackOperations(operations));
    }

}