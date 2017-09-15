
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

        if(item == null) { throw new java.lang.IllegalArgumentException(); }

        Node oldfirst = first; // object link
        first = new Node(); // new object
        first.item = item; // set properties

        first.setNext(oldfirst);

        // checks?
        if(isEmpty()) {
            last = first;
        } else {
            first.setNext(oldfirst);
            first.setPrevious(first);
        }

        size++;
    }

    public void addLast(Item item) {

        if(item == null) { throw new java.lang.IllegalArgumentException(); }

        Node oldlast = last; // object link
        last = new Node(); // new object
        last.item = item; // set properties

        last.setNext(oldlast);

        // checks?
        if(isEmpty()) {
            first = last;
        } else {
            last.setNext(oldlast);
            last.setPrevious(last);
        }

        size++;
    }

    public Item removeFirst() {

        if(isEmpty()) { throw new java.util.NoSuchElementException(); }

        Item item = first.item;
        first = first.getNext();

        size--;
        return item;
    }

    public Item removeLast() {

        if(isEmpty()) { throw new java.util.NoSuchElementException(); }

        Item item = last.item;
        last = last.getNext();

        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private Node node = first;

        @Override
        public boolean hasNext() {
            return first != null && last != null;
        }

        @Override
        public Item next() {

            if(!hasNext()) { throw new java.util.NoSuchElementException(); }
            Item item = node.item;

            return item;
        }

        @Override
        public void remove() {
            throw new java.util.NoSuchElementException();
        }
    }

    private class Node {

        Item item;
        Node next;
        Node previous;

        /* public void setFirst(Node first) {
            this.first = first;
        }

        public Node getFirst() {
            return first;
        }

        public void setLast(Node last) {
            this.last = last;
        }

        public Node getLast() {
            return last;
        } */

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

        /* Deque kek = new Deque();
        kek.addFirst("1");
        kek.addFirst("2");
        kek.addFirst("3");
        kek.addFirst("4");
        kek.addFirst("5");
        kek.addFirst("6");
        kek.addFirst("7");
        kek.addFirst("8");

        System.out.println(kek.removeLast());
        System.out.println(kek.removeLast()); */

    }
}
