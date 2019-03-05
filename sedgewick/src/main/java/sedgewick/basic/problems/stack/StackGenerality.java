package sedgewick.basic.problems.stack;

import java.util.NoSuchElementException;

/**
 * <b>Input:</b> Sequence of intermixed push and pop operations.<br/>
 *  <lu>
 *      <li><i>Push Directives: </i>+ve integers: Push operations with integer value as input</li>
 *      <li><i>Pop Directives: </i>-ve integers: Pop operations with integer values being popped values</li>
 *  </lu>
 * <b>Output:</b> True if the given set of operations does not produce an underflow error. <br/>
 * <b>Constraints:</b>
 *  <lu>
 *      <li>Linear Time Algorithm</li>
 *      <li>Integers can not be stored in a data structure</li>
 *      <li>Space complexity: Amount of space independent of N</li>
 *  </lu>
 */
class StackGenerality {
    static boolean checkStackOperations(final String operations) {
        String[] tokens = operations.split("\\s");
        final int TOKENS = tokens.length;
        int[]  directives = new int[TOKENS];
        for(int i = 0; i < TOKENS; ++i) {
            directives[i] = Integer.parseInt(tokens[i]);
        }

        try {
            return getValidNextOperationIndex(directives, 0) == TOKENS;
        } catch (NoSuchElementException e) {
            return false;   // underflow exception
        }
    }

    private static int getValidNextOperationIndex(int[] directives, int startIndex) throws NoSuchElementException {
        int stackTop = startIndex;
        int operationIndex = startIndex;
        boolean hasPopped = false;

        while((operationIndex < directives.length) && (stackTop >= startIndex)) {
            // check for valid pop directive
            if(directives[operationIndex] < 0) {
                // check for mismatch of expected pop and the actual pop
                if(-directives[stackTop--] != directives[operationIndex++]) {
                   throw new NoSuchElementException(String.format("At index %d: Expected Pop: %d; Actual Pop: %d", operationIndex, directives[stackTop], directives[operationIndex]));
                }

                hasPopped = true;
            } else {
                if(hasPopped) {
                    operationIndex = getValidNextOperationIndex(directives, operationIndex);
                } else {
                    stackTop = operationIndex++;
                }
            }
        }

        return operationIndex;
    }
}
