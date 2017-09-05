
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] dafuk;
    private int trials;
    private int n;
    private Percolation perc;

    public PercolationStats(int n, int trials) {

        this.n = n;
        this.trials = trials;

        if (n < 0 || trials < 1) {
            throw new IllegalArgumentException("N or T < 0");
        }

        dafuk = new double[trials];
        for(int i=0; i<trials; i++) {
            perc = new Percolation(n);
            while(!perc.percolates()) {
                int pop = StdRandom.uniform(1,n+1);
                int pup = StdRandom.uniform(1,n+1);
                if(!perc.isOpen(pop,pup)) {
                    perc.isOpen(pop,pup);
                }
            }
        }
    }

    public double mean() {
        return StdStats.mean(dafuk);
    }

    public double stddev() {
        return StdStats.stddev(dafuk);
    }

    public double confidenceLo() {
        return mean() - (1.96*stddev()/Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + (1.96*stddev()/Math.sqrt(trials));
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Not enough args");
        }

        final int N = Integer.parseInt(args[0]);
        final int M = Integer.parseInt(args[1]);

        PercolationStats percstat = new PercolationStats(N, M);

        System.out.println("mean = " +percstat.mean());
        System.out.println("stddev = " +percstat.stddev());
        System.out.println("conflo = " +percstat.confidenceLo());
        System.out.println("confhi = " +percstat.confidenceHi());

    }
}