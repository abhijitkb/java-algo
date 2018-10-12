package sedgewick.basic.problems.stack;

import sedgewick.basic.ds.stack.ResizingArrayStack;
import sedgewick.basic.ds.stack.Stack;

public class TextEditorBuffer {
    /**
     * Keeps characters to the left of the cursor
     */
    Stack<Character> leftStack = new ResizingArrayStack<>();

    /**
     * Keeps characters to the right of the cursor
     */
    Stack<Character> rightStack = new ResizingArrayStack<>();

    /**
     * Insertions to be done to the left of the cursor as it would be the topmost element for left and can be easily accessed
     * @param c Character to input
     */
    public void insert(final char c) throws Exception {
        this.leftStack.push(c);
    }

    /**
     * Deletes the cursor at the position. Should be the top entry from right stack
     * @return
     */
    public char delete() throws Exception {
       return rightStack.isEmpty() ? '\0' : rightStack.pop();
    }

    /**
     * Move the cursor to the left by {@code position}s
     * @param position
     */
    public void left(int position) throws Exception {
        while(!this.leftStack.isEmpty() && (--position >= 0)) {
            this.rightStack.push(this.leftStack.pop());
        }
    }

    public void right(int position) throws Exception {
        while(!this.rightStack.isEmpty() && (--position >= 0)) {
            this.leftStack.push(this.rightStack.pop());
        }
    }

    public int size() {
        return this.leftStack.size() + this.rightStack.size();
    }
}
