package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Infix2PostfixTest {
    @Test
    void testBasicInfix() throws NoSuchFieldException {
        final String infix = "2 + 3";
        Assertions.assertEquals("2 3 +", Infix2Postfix.getPostFix(infix));
    }

    @Test
    void testSimpleInfix() throws NoSuchFieldException {
        final String infix = "3 + 4 * 5 / 6";
        Assertions.assertEquals("3 4 5 * 6 / +", Infix2Postfix.getPostFix(infix));
    }


    @Test
    void testMediumInfix() throws NoSuchFieldException {
        final String infix = "(300 + 23) * (43 - 21)/(84 + 7)";
        Assertions.assertEquals("300 23 + 43 21 - * 84 7 + /", Infix2Postfix.getPostFix(infix));
    }

    @Test
    void testComplexInfix() throws NoSuchFieldException {
        final String infix = "(4 + 8) * (6 - 5)/((3 - 2)*(2 + 2))";
        Assertions.assertEquals("4 8 + 6 5 - * 3 2 - 2 2 + * /", Infix2Postfix.getPostFix(infix));
    }
}