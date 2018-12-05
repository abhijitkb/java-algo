package sedgewick.basic.ds.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item>, Stack<Item> {
    private Item []  items;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        this.size = 0;
        this.items = (Item [])new Object[1];
    }

    public ResizingArrayStack(final Stack<Item> other) throws Exception {
        Stack<Item> stack = new ResizingArrayStack<>();
        while(!other.isEmpty()) {
            stack.push(other.pop());
        }

        Item value;
        while(!stack.isEmpty()) {
            value = stack.pop();
            push(value);
            other.push(value);
        }
    }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public int size() { return this.size; }

    @Override
    public void push(final Item item) {
        if(this.size == this.items.length)
            resize(this.items.length * 2);

        this.items[this.size++] = item;
    }

    @Override
    public Item pop() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = this.items[--this.size];
        this.items[size] = null;
        return item;
    }

    @Override
    public Item top() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.items[this.size - 1];
    }

    private void resize(final int newSize) {
        @SuppressWarnings("unchecked") Item [] temp = (Item []) new Object[newSize];
        for(int i = 0; i < this.items.length; ++i)
            temp[i] = this.items[i];
        this.items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private final int sizeAtCreation = size;
        private int index = size;


        @Override
        public boolean hasNext() {
            if(sizeAtCreation != size)
                throw new ConcurrentModificationException();
            return index > 0;
        }

        @Override
        public Item next() {
            if(sizeAtCreation != size)
                throw new ConcurrentModificationException();

            return items[--index];
        }
    }

}
