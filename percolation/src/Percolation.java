import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final byte[][] grid;
    private final int top = 0;
    private final int bottom;
    private final int size;
    private int numsites;
    private final WeightedQuickUnionUF wqu;

    public Percolation(int n) {

        if (n < 1) throw new IllegalArgumentException("N isn't greater than 0");

        size = n;
        bottom = size*size+1;
        grid = new byte[size][size];
        numsites = 0;
        wqu = new WeightedQuickUnionUF(bottom+1);

    }

    public void open(int row, int col) {

        if ((row <= 0 || row > size) && (col <= 0 || col > size)) {
            throw new IllegalArgumentException("row index out of bounds");
        }

        grid[row-1][col-1] = 1;

        if (row == 1) {
            wqu.union(index(row, col), top);
        }
        if (row == size) {
            wqu.union(index(row, col), bottom);
        }

        // left/right
        if (col > 1 && isOpen(row, col - 1)) {
            wqu.union(index(row, col), index(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            wqu.union(index(row, col), index(row, col + 1));
        }

        // upper/bottom
        if (row > 1 && isOpen(row - 1, col)) {
            wqu.union(index(row, col), index(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            wqu.union(index(row, col), index(row + 1, col));
        }

        numsites++;
    }

    public boolean isOpen(int row, int col) {

        if ((row <= 0 || row > size) && (col <= 0 || col > size)) {
            throw new IllegalArgumentException("row index out of bounds");
        }

        if (grid[row-1][col-1] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull(int row, int col) {

        if ((row <= 0 || row > size) && (col <= 0 || col > size)) {
            throw new IllegalArgumentException("row index out of bounds");
        } else {
            return wqu.connected(top, index(row, col));
        }
    }

    public int numberOfOpenSites() {
        return numsites;
    }

    public boolean percolates() {

        if (wqu.connected(top, bottom)) {
            return true;
        } else {
            return false;
        }
    }

    private int index(int row, int col) {
        return size * (row-1) + col;
    }
}