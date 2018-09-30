package sedgewick.basic.problems.stack;

import sedgewick.basic.ds.stack.ResizingArrayStack;

public class BinaryRepresentation {

    public static String getBinaryRep(int number) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        while(number > 0) {
            stack.push(number % 2);
            number /= 2;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stack.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
