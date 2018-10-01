package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostFixEvalTest {

    @Test
    void testBasic() {
        final String postFix = "2 3 +";
        Assertions.assertEquals(5, PostFixEval.eval(postFix));
    }

    @Test
    void testSimple() {
        final String postFix = "3 + 4 * 5 / 6";
        Assertions.assertEquals(6.333333333, PostFixEval.eval(postFix), 0.0001);
    }

    @Test
    void testMedium() {
        final String postFix = "(300 + 23) * (43 - 21)/(84 + 7)";
        Assertions.assertEquals(78.0879, PostFixEval.eval(postFix), 0.0001);
    }

    @Test
    void testComplex() {
        final String postFix = "(4 + 8) * (6 - 5)/((3 - 2)*(2 + 2))";
        Assertions.assertEquals(3, PostFixEval.eval(postFix), 0.0001);
    }
}