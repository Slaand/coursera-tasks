
import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Not enough args");
        }

        final int param = Integer.parseInt(args[0]); // read

        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        if (param < 0 || param > queue.size()) {
            throw new java.lang.IllegalArgumentException();
        }

        for (int i = 0; i < param; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
