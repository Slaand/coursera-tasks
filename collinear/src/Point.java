import java.util.Comparator;

import static edu.princeton.cs.algs4.StdDraw.line;
import static edu.princeton.cs.algs4.StdDraw.point;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public void draw() { point(x, y); }

    public void drawTo(Point that) { line(this.x, this.y, that.x, that.y); }

    public String toString() { return "(" + x + ", " + y + ")"; }

    public int compareTo(Point that) {

        if (this.y == that.y) return this.x - that.x;
        return this.y - that.y;
    }

    public double slopeTo(Point that) {

        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        } else if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        } else if (this.y == that.y) {
            return +0.0;
        }

        return (double) (that.y - this.y) / (that.x - this.x);
    }

    public Comparator<Point> slopeOrder() { return new SlopeOrder(); }

    private class SlopeOrder implements Comparator<Point> {

        public int compare(Point q1, Point q2) {

            double slope1 = slopeTo(q1);
            double slope2 = slopeTo(q2);
            return Double.compare(slope1, slope2);
        }
    }
}