package sedgewick.basic.problems.stack;


import sedgewick.basic.ds.stack.ResizingArrayStack;

/*
Write a program that takes from standard input an expression without left
parentheses and prints the equivalent infix expression with the parentheses
inserted. For example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
your program should print:
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class FixInfixExpr {

    public static String fixInfix(final String exprStr) throws NoSuchFieldException {
        ResizingArrayStack<Character> operators = new ResizingArrayStack<>();
        ResizingArrayStack<String> operands = new ResizingArrayStack<>();

        char curChar;
        for(int i = 0; i < exprStr.length(); ++i) {
            curChar = exprStr.charAt(i);
            switch (curChar) {
                case '*':
                case '/':
                case '+':
                case '-':
                    operators.push(curChar);
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
                    operands.push(String.format("%c", curChar));
                    break;
                case ')':
                    // We have our expression backwards in the original stack
                    String secondOperand = operands.pop();
                    String firstOperand = operands.pop();
                    Character operator = operators.pop();
                    String expr = String.format("( %s %c %s )", firstOperand, operator, secondOperand);
                    operands.push(expr);
                    break;
                default:
                    break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!operands.isEmpty())
            stringBuilder.append(operands.pop());

        return stringBuilder.toString();
    }
}
