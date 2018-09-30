package sedgewick.basic.ds.stack;

public class FixedCapacityStack<Item> {
    private Item []  items;
    private final int capacity;
    private int size = -1;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(final int capacity) {
        this.capacity = capacity;
        this.items = (Item [])new Object[capacity];
    }

    public boolean isEmpty() { return this.size == 0; }
    public boolean isFull() { return this.capacity == this.size; }
    public int size() { return this.size; }

    public void push(final Item item) {
        if(this.size < this.capacity) {
            this.items[this.size++] = item;
        } else {
            throw new IndexOutOfBoundsException(String.format("%s is full!", getClass().getSimpleName()));
        }
    }

    public Item pop() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException(String.format("%s is empty!", getClass().getSimpleName()));
        }
        Item item = this.items[--this.size];
        this.items[size] = null;
        return item;
    }
}
