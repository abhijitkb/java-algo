package sedgewick.basic.ds.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomQueue <T> implements Queue<T> {
    private Random random;
    private T [] elements;
    private int capacity = 0;
    private int size = 0;
    private Class<?> componentType;

    public RandomQueue(final T [] refArray) {
        this.random = ThreadLocalRandom.current();
        this.componentType = refArray.getClass().getComponentType();
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        this.capacity <<= 1;
        T[] temp = (T[]) java.lang.reflect.Array.newInstance(this.componentType, capacity);
        System.arraycopy(elements, 0, temp, 0, this.elements.length);
        this.elements = temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(T value) {
        Objects.requireNonNull(value);
        if(isFull())
            resize();
        this.elements[this.size++] = value;
    }

    /**
     * Deletes a random element
     * @return
     */
    @Override
    public T dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();

        int randomIndex = random.nextInt(this.size--);
        T value = elements[randomIndex];
        if(randomIndex != this.size)    this.elements[randomIndex] = this.elements[this.size];
        this.elements[this.size] = null;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<T> {
        private int current = 0;
        private T[] workingSet;

        @SuppressWarnings("unchecked")
        public RandomIterator() {
            this.workingSet = (T[])java.lang.reflect.Array.newInstance(componentType, size);
            shuffle();
        }

        private void shuffle() {
            T temp;
            int randomIndex;
            for(int i = size - 1; i > 0; ++i) {
                randomIndex = random.nextInt(i + 1);
                temp = workingSet[randomIndex];
                workingSet[randomIndex] = workingSet[i];
                workingSet[i] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return this.current < size;
        }

        @Override
        public T next() {
            if(!hasNext())      throw new NoSuchElementException();

            return workingSet[current++];
        }
    }
}
