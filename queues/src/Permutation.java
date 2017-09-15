
import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Not enough args");
        }

        final int nums = Integer.parseInt(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        if (nums < 0 || nums > queue.size()) {
            throw new java.lang.IllegalArgumentException();
        }

        for (int i = 0; i < nums; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
