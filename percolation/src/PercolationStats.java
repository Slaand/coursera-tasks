
import edu.princeton.cs.algs4.StdStats;
import static edu.princeton.cs.algs4.StdRandom.uniform;

public class PercolationStats {

    private final double[] dafuk;
    private final int checks;

    public PercolationStats(int size, int checks) {

        this.checks = checks;

        if (size <= 0 || checks < 1) {
            throw new IllegalArgumentException("N or T param <= 0");
        }

        dafuk = new double[checks];
        for (int i = 0; i < checks; i++) {
            Percolation perc = new Percolation(size);
            while (!perc.percolates()) {
                int pop = uniform(1, size+1);
                int pup = uniform(1, size+1);
                if (!perc.isOpen(pop, pup)) {
                    perc.open(pop, pup);
                }
            }
            dafuk[i] = (double) perc.numberOfOpenSites() / (size * size);
        }
    }

    public double mean() {
        return StdStats.mean(dafuk);
    }

    public double stddev() {
        return StdStats.stddev(dafuk);
    }

    public double confidenceLo() {
        return mean() - ((1.96*stddev())/Math.sqrt(checks));
    }

    public double confidenceHi() {
        return mean() + ((1.96*stddev())/Math.sqrt(checks));
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Not enough args");
        }

        final int size = Integer.parseInt(args[0]);
        final int checks = Integer.parseInt(args[1]);

        PercolationStats percstat = new PercolationStats(size, checks);

        System.out.println("mean = " +percstat.mean());
        System.out.println("stddev = " +percstat.stddev());
        System.out.println("conflo = " +percstat.confidenceLo());
        System.out.println("confhi = " +percstat.confidenceHi());

    }
}