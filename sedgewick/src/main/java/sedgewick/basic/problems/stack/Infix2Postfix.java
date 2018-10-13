package sedgewick.basic.problems.stack;

import sedgewick.basic.ds.stack.ResizingArrayStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert an infix expression to postfix
 *      2 + 3 => 2 3 +
 *      3 + 4 * 5 / 6  => 3 4 5 * 6 / +
 *      (300 + 23) * (43 - 21)/(84 + 7)  => 300 23 + 43 21 - * 84 7 + /
 *      (4 + 8) * (6 - 5)/((3 - 2)*(2 + 2))  => 4 8 + 6 5 - * 3 2 - 2 2 + * /
 */
public class Infix2Postfix {
    public static boolean hasLowerPreference(final char op1, final char op2) {
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

    public static String getPostFix(final String infix) throws NoSuchFieldException {
        List<String> postFixExpr = new ArrayList<>();
        ResizingArrayStack<Character> operators = new ResizingArrayStack<>();

        String number = "";
        char curChar;
        for(int i = 0; i < infix.length(); ++i) {
            curChar = infix.charAt(i);
            switch (curChar) {
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
                    number += curChar;
                    if(i < infix.length() - 1) {
                        if(!Character.isDigit(infix.charAt(i + 1))) {
                            postFixExpr.add(number);
                            number = "";
                        }
                    } else {
                        // the last character
                        postFixExpr.add(number);
                    }
                    break;
                // operator with lowest precedence
                case '(':
                    operators.push(curChar);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!operators.isEmpty()) {
                        char operator = operators.pop();
                        if(hasLowerPreference(curChar, operator)) {
                            operators.push(operator);
                            break;
                        }
                        postFixExpr.add(String.format("%c", operator));
                    }
                    operators.push(curChar);
                    break;
                case ')':
                    // keep on popping till matching '(' is found
                    while(!operators.isEmpty()) {
                        char operator = operators.pop();
                        if(operator == '(')
                            break;
                        postFixExpr.add(String.format("%c", operator));
                    }
            }
        }

        while(!operators.isEmpty()) {
            char operator = operators.pop();
            if(operator != '(')
                postFixExpr.add(String.format("%c", operator));
        }

        return String.join(" ", postFixExpr);
    }
}
