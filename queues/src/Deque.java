
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private int size = 0;
    private Node first, last;

    public Deque() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {

        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }

        Node oldFirst = first;
        first = new Node();
        first.item = item;

        // checks?
        if (isEmpty()) {
            last = first;
            first.setNext(null);
        } else {
            first.setNext(oldFirst);
            oldFirst.setPrevious(first);
        }
        first.setPrevious(null);

        size++;
    }

    public void addLast(Item item) {

        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }

        Node oldLast = last;
        last = new Node();
        last.item = item;

        // checks?
        if (isEmpty()) {
            first = last;
            last.setPrevious(null);
        } else {
            oldLast.setNext(last);
            last.setPrevious(oldLast);
        }
        last.setNext(null);

        size++;
    }

    public Item removeFirst() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Item item = first.item;
        first = first.getNext();

        if (size() == 1) {
            last = null;
            first = null;
        } else {
            first.setPrevious(null);
        }

        size--;
        return item;
    }

    public Item removeLast() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Item item = last.item;
        last = last.getPrevious();

        if (size() == 1) {
            last = null;
            first = null;
        } else {
            last.setNext(null);
        }

        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private Node object = first;

        public boolean hasNext() {
            return object != null;
        }

        public Item next() {

            Item item = object.item;
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            object = object.getNext();
            return item;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    private class Node {

        Item item;
        Node next;
        Node previous;

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getPrevious() {
            return previous;
        }
    }

    public static void main(String[] args) {
        // unit testing (optional)

        int N = 100;
        int h = 1;

        while (h < N/3) h = 3*h + 1;
        System.out.println(h);

    }
}
