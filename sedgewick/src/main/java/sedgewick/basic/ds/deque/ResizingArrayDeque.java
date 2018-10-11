package sedgewick.basic.ds.deque;

public class ResizingArrayDeque<T> implements IDeque<T> {
    private T[] elements;
    private int size = 0;
    private int capacity = 1; // start with default of 1
    private final Class<?> clazz;

    public ResizingArrayDeque(final T[] a) {
        clazz = a.getClass().getComponentType();
        this.elements = allocateArray(this.capacity);
    }

    @SuppressWarnings("unchecked")
    private T[] allocateArray(int capacity) {
        this.capacity = capacity;
        return (T[]) java.lang.reflect.Array.newInstance(clazz, capacity);
    }

    private void resizeArray() {
        T[] temp = allocateArray(this.capacity << 1);
        System.arraycopy(elements, 0, temp, 0, this.size);
        elements = temp;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean isFull() {
        return this.size == (this.capacity - 1);
    }

    @Override
    public void pushLeft(T value) {
        if(isFull()) {
            resizeArray();
        }

        for(int i = this.size++; i > 0; --i) {
            elements[i] = elements[i - 1];
        }

        elements[0] = value;
    }

    @Override
    public void pushRight(T value) {
        if(isFull()) {
            resizeArray();
        }
        elements[size++] = value;
    }

    @Override
    public T popLeft() {
        if(isEmpty())
            throw new IllegalArgumentException("popLeft attempted on empty deque");
        T value = elements[0];
        --this.size;
        for(int i = 0; i < this.size; ++i) {
            elements[i] = elements[i + 1];
        }
        elements[size] = null;
        return value;
    }

    @Override
    public T popRight() {
        if(isEmpty())
            throw new IllegalArgumentException("popLeft attempted on empty deque");
        T value = elements[--size];
        elements[size] = null;
        return value;
    }
}
