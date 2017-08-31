import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] status;
    private int top;
    private int bottom;
    private int size;
    private WeightedQuickUnionUF wqu;

    public Percolation(int n) {

        if (n < 1) throw new IllegalArgumentException("N isn't greater than 0");

        size = n;
        top = 0; bottom = size*size;
        status = new boolean[size][size];
        wqu = new WeightedQuickUnionUF(size);

    }

    public void open(int row, int col) {

        status[row][col] = true;
        wqu.union(row, col);
    }

    public boolean isOpen(int row, int col) {
        return status[row][col];
    }

    public boolean isFull(int row, int col) {
        if(0 < row && row <= size && 0 < col && col <= size) {
            return wqu.connected(row-1, col-1);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean percolates() {
        return wqu.connected(top, bottom);
    }
}