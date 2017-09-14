import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    private static int size = 0;
    private static String[] mass = new String[1];

    private static void resize(int capacity) {

        String[] copy = new String[capacity];
        for(int i=0; i<mass.length; i++) {
            copy[i] = mass[i];
        }
        mass = copy;
    }

    public static void main(String[] args) {

        if (args.length < 1) { System.out.println("Not enough args"); }
        final int nums = Integer.parseInt(args[0]);

        String test = "A B C D E F G";
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        /*while(word != null) {
            if(size == mass.length) { resize(2*mass.length); }
            word = StdIn.readString();
            mass[size] = word;
            size++;
        }*/



        System.out.println(mass);

    }
}
