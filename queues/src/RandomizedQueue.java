import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size = 0;

    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {

        Item[] copy = (Item[]) new Object[capacity];
        for(int i=0; i<queue.length; i++) {
            copy[i] = queue[i];
        }
        queue = copy;
    }

    public void enqueue(Item item) {

        if(item == null) { throw new java.lang.IllegalArgumentException(); }
        if(size == queue.length) { resize(2 * queue.length); }
        queue[size++] = item;
    }

    public Item dequeue() {

        if(isEmpty()) { throw new java.util.NoSuchElementException(); }
        if(size > 0 && size == queue.length / 4) resize(queue.length / 2);

        int randNum = StdRandom.uniform(0, size());
        Item rand = this.queue[randNum];

        queue[randNum] = null;

        return rand;
    }

    public Item sample() {

        if(isEmpty()) { throw new java.util.NoSuchElementException(); }
        int randNum = StdRandom.uniform(0, size());
        return queue[randNum];
    }

    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                if(size <= 0) {
                    throw new java.util.NoSuchElementException();
                } else {
                    return true;
                }
            }

            @Override
            public Item next() {

                if(size <= 0) { throw new java.util.NoSuchElementException(); }
                //Item item = this.queue
                return null;
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        // unit testing (optional)

        /*RandomizedQueue rand = new RandomizedQueue();
        rand.enqueue("1");
        rand.enqueue("2");
        rand.enqueue("3");
        rand.enqueue("4");
        rand.enqueue("5");
        rand.enqueue("6");
        System.out.println(rand.size());
        for(int i=0; i<rand.size(); i++) {
            System.out.println(rand.dequeue());
        }*/

    }

}
