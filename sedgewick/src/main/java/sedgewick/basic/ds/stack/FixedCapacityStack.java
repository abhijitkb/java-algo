package sedgewick.basic.ds.stack;

import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Stack<Item> {
    private Item []  items;
    private final int capacity;
    private int size = -1;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(final int capacity) {
        this.capacity = capacity;
        this.items = (Item [])new Object[capacity];
    }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    public boolean isFull() { return this.capacity == this.size; }

    @Override
    public int size() { return this.size; }

    @Override
    public void push(final Item item) throws Exception {
        if(isFull())
            throw new Exception("Stack is full!");

        if(this.size < this.capacity) {
            this.items[this.size++] = item;
            return;
        }

        throw new NoSuchElementException();
    }

    @Override
    public Item pop() throws NoSuchElementException {
        if(isEmpty())   throw new NoSuchElementException();

        Item item = this.items[--this.size];
        this.items[size] = null;
        return item;
    }

    @Override
    public Item top() throws NoSuchElementException {
        if(isEmpty())       throw new NoSuchElementException();
        return this.items[this.size - 1];
    }
}
