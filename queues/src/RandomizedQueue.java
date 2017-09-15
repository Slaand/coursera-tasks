
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
        for (int i = 0; i < queue.length; i++) {
            copy[i] = queue[i];
        }
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

        // if(size > 0 && size == queue.length / 4) resize(queue.length / 2);

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
        return new Iterator<Item>() {

            private int num = 0;

            @Override
            public boolean hasNext() {
                if (size <= 0) {
                    throw new java.util.NoSuchElementException();
                } else {
                    return true;
                }
            }

            @Override
            public Item next() {
                if (size <= 0) {
                    throw new java.util.NoSuchElementException();
                }
                return queue[num++];
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        // unit testing (optional)
    }
}
