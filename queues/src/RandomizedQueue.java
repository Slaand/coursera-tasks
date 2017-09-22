
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size = 0;

    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {

        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(queue, 0, copy, 0, queue.length);
        queue = copy;
    }

    public void enqueue(Item item) {

        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }

        if (size == queue.length) {
            resize(2 * queue.length);
        }

        queue[size++] = item;
    }

    public Item dequeue() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        int randNum = StdRandom.uniform(size());
        Item rand = this.queue[randNum];

        if (randNum != size - 1) queue[randNum] = queue[size - 1];
        queue[--size] = null;
        return rand;
    }

    public Item sample() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int randNum = StdRandom.uniform(size());
        return queue[randNum];
    }

    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {

        private int tempSize = size;
        private final Item[] copy;

        private RandomizedIterator() {
            copy = (Item[]) new Object[tempSize];
            System.arraycopy(queue, 0, copy, 0, tempSize); // queue -> copy
        }

        public boolean hasNext() {
            return tempSize > 0;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        public Item next() {

            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            int randNum = StdRandom.uniform(tempSize);
            Item item = copy[randNum];
            copy[--tempSize] = null;
            return item;
        }
    }

    public static void main(String[] args) {
        // unit testing (optional)
    }
}
