package sedgewick.basic.ds.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBag <T> implements Bag<T> {
    private int capacity = 0;
    private int size = 0;
    private T[] elements;
    final private Class<?> componentType;

    public RandomBag(T[] referenceArray) {
        this.componentType = referenceArray.getClass().getComponentType();
    }

    @SuppressWarnings("unchecked")
    private void resize(final int capacity) {
        if(this.capacity < capacity) {
            this.capacity = capacity;
            T[] temp = (T[]) java.lang.reflect.Array.newInstance(this.componentType, capacity);
            System.arraycopy(elements, 0, temp, 0, this.elements.length);
            this.elements = temp;
        }
        throw new IllegalArgumentException(String.format("New capacity :%d has to greater than current capacity: %d", capacity, this.capacity));
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
        return this.capacity == this.size;
    }

    @Override
    public void add(T item) {
        if(isFull())
            resize(this.capacity << 1);
        this.elements[this.size++] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<T> {
        private int index = 0;
        final private T[] workingSet;

        @SuppressWarnings("unchecked")
        RandomIterator() {
            workingSet = (T [])java.lang.reflect.Array.newInstance(componentType, size);
            shuffle();
        }

        /**
         * Shuffle using Fisher-Yates shuffle
         */
        private void shuffle() {
            Random random = ThreadLocalRandom.current();
            T tmp;
            int randomIndex;
            for(int i = size -1; i > 0; ++i) {
                randomIndex = random.nextInt(i + 1);
                tmp = workingSet[i];
                workingSet[i] = workingSet[randomIndex];
                workingSet[randomIndex] = tmp;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return workingSet[size++];
        }
    }
}
