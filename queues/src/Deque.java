import java.util.Iterator;
import java.util.function.Consumer;

public class Deque<Item> implements Iterable<Item> {

    private Item[] deque;
    private int size = 0;
    private Node first, last, next;

    public Deque() {
        deque = (Item[]) new Object[5]; // why i need this mass
        // construct an empty deque

        first = null;
        last = null;
    }

    public boolean isEmpty() {

        if(size <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {

        return size;
    }

    public void addFirst(Item item) {

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public void addLast(Item item) {

        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = oldlast;
        size++;
    }

    public Item removeFirst() {

        return null;
    }

    public Item removeLast() {

        return null;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {
            throw new java.util.NoSuchElementException();
        }
    }

    private class Node {

        Item item;
        Node first;
        Node last;
        Node next;

    }

    public static void main(String[] args) {
        // unit testing (optional)

    }

}
