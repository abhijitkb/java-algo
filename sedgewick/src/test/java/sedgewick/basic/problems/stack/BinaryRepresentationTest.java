package sedgewick.basic.problems.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryRepresentationTest {
    @Test
    void testBinary50() {
        String value = BinaryRepresentation.getBinaryRep(50);
        Assertions.assertEquals("110010", value);
    }
}