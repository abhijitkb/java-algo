package sedgewick.basic.problems.linkedlist;


import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

final public class Josephus {
    private class CircularArray {
        private int size;
        private int [] buffer;
        private int index = 6;

        public CircularArray(int size) {
            this.size = size;
            this.buffer = new int[this.size];

            for (int i = 0; i < this.size; i++) {
                this.buffer[i] = i;
            }
        }

        void step() {
            this.index += stepBy;
            if(this.index >= this.size)
                this.index %= this.size;
        }

        int remove() {
            if(this.index == -1)
                throw new NoSuchElementException();

            int current = this.buffer[this.index];
            --this.size;
            for (int i = this.index; i < this.size; i++) {
                this.buffer[i] = this.buffer[i + 1];
            }
            this.index = prevIndex();
            return current;
        }

        private int prevIndex() {
            return this.index == 0 ? this.size - 1 : this.index - 1;
        }

        boolean isEmpty() { return this.size == 0; }

        int getIndex() { return index; }
    }

    CircularArray circularList;

    private final int stepBy;

    public Josephus(final int size, final int step) {
        this.circularList = new CircularArray(size);
        this.stepBy = step;
    }

    public Collection<Integer> showEliminations() {
        Collection<Integer> eliminatedPositions = new ArrayList<>();

        while (!this.circularList.isEmpty()) {
            this.circularList.step();
            eliminatedPositions.add(circularList.remove());
        }

        return eliminatedPositions;
    }
}
