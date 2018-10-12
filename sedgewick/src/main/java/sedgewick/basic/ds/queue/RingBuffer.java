package sedgewick.basic.ds.queue;

public class RingBuffer <T> {
    private final int capacity;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    private T [] ringBuffer;

    @SuppressWarnings("unchecked")
    public RingBuffer(final T [] refArray, final int capacity) {
        this.capacity = capacity;
        ringBuffer = (T[]) java.lang.reflect.Array.newInstance(refArray.getClass().getComponentType(), this.capacity);
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public boolean isFull() {
        return nextIndex(this.tail) == this.head;
    }

    public int size() {
        return this.size;
    }

    public boolean offer(final T value) {
        if(!isFull()) {
            this.ringBuffer[this.tail] = value;
            this.tail = nextIndex(this.tail); // increment tail
            this.size++;
            return true;
        }
        return false;
    }

    public T claim() {
        if(isEmpty())
            return null;
        final T value = this.ringBuffer[this.head];
        this.head = nextIndex(this.head); // increment head
        this.size--;
        return value;
    }

    private int nextIndex(int index) {
        index++;
        if(index == this.capacity)
            return 0;
        return index;
    }
}
