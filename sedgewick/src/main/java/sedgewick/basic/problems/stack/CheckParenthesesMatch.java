package sedgewick.basic.problems.stack;

import sedgewick.basic.ds.stack.ResizingArrayStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckParenthesesMatch {
    private static final List<Character> allParentheses = Arrays.asList('(', ')', '{', '}', '[', ']');
    private static final Map<Character, Character> parenthesisMatcher;

    static {
        parenthesisMatcher = new HashMap<>();
        parenthesisMatcher.put(')', '(');
        parenthesisMatcher.put('}', '{');
        parenthesisMatcher.put(']', '[');
    }

    private ResizingArrayStack<Character> parentheses = new ResizingArrayStack<>();

    private void push(final Character character) {
        this.parentheses.push(character);
    }

    private Character pop() throws NoSuchFieldException {
        return this.parentheses.pop();
    }

    public boolean check(final String text) throws NoSuchFieldException {
        if ((text == null) || text.isEmpty())
            return true;

        // only push the parentheses
        Character current;
        for(int i = 0; i < text.length(); ++i) {
            current = text.charAt(i);
            if(allParentheses.contains(current))
                parentheses.push(current);
        }

        // now closing parenthesis must match the opening parenthesis
        boolean matched = true;
        while(!this.parentheses.isEmpty())
            matched = matchClosingParenthesis(this.parentheses.pop());
        return matched;
    }

    private boolean matchClosingParenthesis(final Character closingParenthesis) throws NoSuchFieldException {
        Character openingParenthesis = parenthesisMatcher.get(closingParenthesis);

        Character current;
        while(!this.parentheses.isEmpty()) {
            current = this.parentheses.pop();
            if(parenthesisMatcher.containsKey(current)) {
                if(!matchClosingParenthesis(current))
                    return false;
            }

            if(current.equals(openingParenthesis))
                return true;
        }

        return false;
    }
}
