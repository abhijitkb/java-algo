package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixInfixExprTest {

    @Test
    void test() {
        String infix = FixInfixExpr.fixInfix("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
        Assertions.assertEquals("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )", infix);
    }
}