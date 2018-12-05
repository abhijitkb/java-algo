package sedgewick.basic.problems.stack;

import sedgewick.basic.ds.stack.ResizingArrayStack;
import sedgewick.basic.ds.stack.Stack;

import java.util.List;
import java.util.Objects;

public class StackGenerality {

    /**
     * Checks to see for a given series of input for a stack, can the output be matched.
     * <p>
     *     This only works with unique numbers
     * </p>
     * @param input   Input for Stack
     * @param output  Expected possible output permutation
     * @param <T>     Underlying Type
     * @return        True is the output pattern can be matched.
     */
    public static <T> boolean canMatchOutputUnique(List<T> input, List<T> output) {
        Objects.requireNonNull(input);
        Objects.requireNonNull(output);

        Stack<T> stack = new ResizingArrayStack<>();

        final int outputLength = output.size();
        int curOpIdx = 0;

        try {
            for(T value : input) {
                stack.push(value);

                while((curOpIdx < outputLength) && !stack.isEmpty() ){
                    if(stack.top().equals(output.get(curOpIdx))) {
                        stack.pop();
                        ++curOpIdx;
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {

        }

        return stack.isEmpty();
    }
}
