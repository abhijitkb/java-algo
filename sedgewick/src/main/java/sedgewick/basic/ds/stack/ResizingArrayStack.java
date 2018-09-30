package sedgewick.basic.ds.stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item []  items;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        this.size = 0;
        this.items = (Item [])new Object[1];
    }

    public boolean isEmpty() { return this.size == 0; }
    public int size() { return this.size; }

    public void push(final Item item) {
        if(this.size == this.items.length)
            resize(this.items.length * 2);

        this.items[this.size++] = item;
    }

    public Item pop() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException(String.format("%s is empty!", getClass().getSimpleName()));
        }
        Item item = this.items[--this.size];
        this.items[size] = null;
        return item;
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
        private int index = size;


        @Override
        public boolean hasNext() {

            return index > 0;
        }

        @Override
        public Item next() {
            return items[--index];
        }
    }

}
