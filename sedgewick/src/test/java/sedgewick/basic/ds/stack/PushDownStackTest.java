package sedgewick.basic.ds.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PushDownStackTest {
    private PushDownStack<String> stack;

    @BeforeEach
    void setup() {
        stack = new PushDownStack<>();
    }

    @Test
    void testPushes() {
        stack.push("Hello");
        stack.push("World");
        stack.push("Everyone");
        stack.forEach(System.out::println);
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    void testPops() {
        stack.push("Hello");
        stack.push("World");
        stack.push("Everyone");
        Assertions.assertEquals(3, stack.size());

        Assertions.assertEquals("Everyone", stack.pop());
        Assertions.assertEquals(2, stack.size());
        stack.forEach(System.out::println);

        stack.pop();
        stack.pop();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void testPushPops() {
        stack.push("Hello");
        stack.push("World");
        stack.push("Everyone");
        Assertions.assertEquals(3, stack.size());

        Assertions.assertEquals("Everyone", stack.pop());
        Assertions.assertEquals(2, stack.size());

        stack.push("from India");
        Assertions.assertEquals(3, stack.size());
        stack.forEach(System.out::println);

        Assertions.assertEquals("from India", stack.pop());
    }
}