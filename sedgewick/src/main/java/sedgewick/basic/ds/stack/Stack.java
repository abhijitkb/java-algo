package sedgewick.basic.ds.stack;

public interface Stack<T> {
    /**
     * Is {@link Stack} empty?
     * @return true iff empty
     */
    boolean isEmpty();

    /**
     * Get the total number of elements present in {@link Stack}
     * @return the total number of elements.
     */
    int size();

    /**
     * Add an element in {@link Stack}
     * @param item input to be pushed in the {@link Stack}
     */
    void push(final T item);

    /**
     * Extract the latest entry from the {@link Stack}
     * @return the head element.
     * @throws java.util.NoSuchElementException when the stack is empty.
     */
    T pop();

    /**
     * Get the latest entry from the {@link Stack}; the latest entry would NOT be removed
     * @return the head element.
     * @throws java.util.NoSuchElementException when the stack is empty.
     */
    T top();
}
