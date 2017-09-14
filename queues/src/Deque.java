import java.util.Iterator;
import java.util.function.Consumer;

public class Deque<Item> implements Iterable<Item> {

    private Item[] enqueue;
    private Item[] dequeue;
    private int size = 0;
    private int N,M = 0;
    private Node first, last;

    public Deque() {
        enqueue = (Item[]) new Object[1];
        dequeue = (Item[]) new Object[1];
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

    private void resizeEnq(int capacity) {

        Item[] copy = (Item[]) new Object[capacity];
        for(int i=0; i<enqueue.length; i++) {
            copy[i] = enqueue[i];
        }
        enqueue = copy;
    }

    private void resizeDeq(int capacity) {

        Item[] copy = (Item[]) new Object[capacity];
        for(int i=0; i<dequeue.length; i++) {
            copy[i] = dequeue[i];
        }
        dequeue = copy;
    }

    public void addFirst(Item item) {

        if(item == null) { throw new java.lang.IllegalArgumentException(); }
        if(N == enqueue.length) { resizeEnq(2 * enqueue.length); }

        Node oldfirst = first; // object link
        first = new Node(); // new object
        first.item = item; // set properties

        enqueue[N++] = item;
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
        if(M == dequeue.length) { resizeDeq(2 * dequeue.length); }

        Node oldlast = last; // object link
        last = new Node(); // new object
        last.item = item; // set properties

        dequeue[M++] = item;
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
        if(N > 0 && N == enqueue.length / 4) resizeEnq(enqueue.length / 2);

        Item item = first.item;
        first = first.getNext();
        enqueue[--N] = null; //N--;

        size--;
        return item;
    }

    public Item removeLast() {

        if(isEmpty()) { throw new java.util.NoSuchElementException(); }
        if(M > 0 && M == dequeue.length / 4) resizeDeq(dequeue.length / 2);

        Item item = last.item;
        last = last.getNext();
        dequeue[--M] = null; //M--;

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
        Node first;
        Node last;
        Node next;
        Node previous;

        public void setFirst(Node first) {
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
        }

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
        Deque kek = new Deque();
        /*kek.addFirst("1");
        kek.addFirst("2");
        kek.addFirst("3");

        System.out.println(kek.size());
        System.out.println(kek.toString());

        kek.removeFirst();
        kek.addFirst("4");
        kek.addFirst("5");

        for(int i=0; i<kek.size(); i++) {
            System.out.println(kek.removeFirst());
        }*/

        // ------------------------------------

        kek.addLast("5");
        kek.addLast("4");
        kek.addLast("3");

        //System.out.println(kek.size());
        //System.out.println(kek.toString());

        kek.removeLast();
        kek.addLast("2");
        kek.addLast("1");
        System.out.println(kek.size());

        for(int i=0; i<kek.size(); i++) {
            System.out.println(kek.removeLast());
        }

        System.out.println(kek.size());
    }
}
