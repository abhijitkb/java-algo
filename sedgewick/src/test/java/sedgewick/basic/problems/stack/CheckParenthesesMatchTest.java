package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckParenthesesMatchTest {
    private CheckParenthesesMatch matcher;

    @BeforeEach
    void setup() {
        matcher = new CheckParenthesesMatch();
    }

    @Test
    void testSimpleMatch() throws NoSuchFieldException {
        String str = "()";
        Assertions.assertTrue(matcher.check(str));
    }

    @Test
    void testSimpleMisMatch() throws NoSuchFieldException {
        String str = ")(";
        Assertions.assertFalse(matcher.check(str));
    }

    @Test
    void testComplexMatch() throws NoSuchFieldException {
        String str = "[()]{}{[()()]()}";
        Assertions.assertTrue(matcher.check(str));

    }
}