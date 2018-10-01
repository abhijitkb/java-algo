package sedgewick.basic.problems.stack;

import sedgewick.basic.ds.stack.ResizingArrayStack;

public class PostFixEval {

    private static void eval(final ResizingArrayStack<Double> operands, final char operator) {
        double later = operands.pop();
        double former = operands.pop();
        double result = eval(former, later, operator);
        operands.push(result);
    }

    private static double eval(final double val1, final double val2, final char op) {
        switch (op) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
        }
        throw new UnsupportedOperationException("Only +, -, * and / are supported!");
    }

    private static boolean hasLowerPreference(final char op1, final char op2) {
        switch (op1) {
            case '*':
            case '/':
                return (op2 == '+' || op2 == '-' || op2 == '(');
            case '+':
            case '-':
                return (op2 == '(');
        }
        return false;
    }

    public static double eval(final String postFixExpr) {
        ResizingArrayStack<Character> operators = new ResizingArrayStack<>();
        ResizingArrayStack<Double> operands = new ResizingArrayStack<>();

        String number = "";
        char cur;
        for (int i = 0; i < postFixExpr.length(); ++i) {
            cur = postFixExpr.charAt(i);
            switch (cur) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operators.isEmpty()) {
                        char operator = operators.pop();
                        if (hasLowerPreference(cur, operator)) {
                            operators.push(operator);
                            break;
                        }
                        eval(operands, operator);
                    }
                    operators.push(cur);
                    break;
                case '(':
                    operators.push(cur);
                    break;
                case ')':
                    // pop till a matching ')' is found
                    while (!operators.isEmpty()) {
                        char operator = operators.pop();
                        if(operator == '(') break;
                        eval(operands, operator);
                    }
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                case '.':
                    number += cur;
                    // check if its the last character of the input string
                    if (i + 1 == postFixExpr.length()) {
                        operands.push(Double.parseDouble(number));
                        number = "";
                    } else {
                        char nextChar = postFixExpr.charAt(i + 1);
                        if (nextChar != '.' && !Character.isDigit(nextChar)) {
                            operands.push(Double.parseDouble(number));
                            number = "";
                        }
                    }
            }
        }

        // now apply all the remaining operators
        while(!operators.isEmpty()) {
            char operator = operators.pop();
            eval(operands, operator);
        }

        assert operands.size() == 1 : "At the end the operand should only contain the result";
        return operands.pop();
    }
}
