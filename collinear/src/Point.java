import java.util.Comparator;
import static edu.princeton.cs.algs4.StdDraw.line;
import static edu.princeton.cs.algs4.StdDraw.point;

public class Point implements Comparable<Point> {

    private int x;
    private int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
        // constructs the point (x, y)
    }

    public void draw() {

        point(x, y);
        // draws this point
    }

    public void drawTo(Point that) {

        line(this.x, this.y, that.x, that.y);
        // draws the line segment from this point to that point
    }

    public String toString() {

        return "(" + x + ", " + y + ")";
        // string representation
    }

    public int compareTo(Point that) {

        if (this.y == that.y) return this.x - that.x;
        return this.y - that.y;

        // compare two points by y-coordinates, breaking ties by x-coordinates
    }

    public double slopeTo(Point that) {

        if (this.y == that.y) {
            if (this.x == that.x) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }

        if(this.x == that.x) { return 0.0; }

        return (double) (that.y - this.y) / (that.x - this.x);
        // the slope between this point and that point
    }

    public Comparator<Point> slopeOrder() {

        return new SlopeOrder();
        // compare two points by slopes they make with this point
    }

    private class SlopeOrder implements Comparator<Point> {

        public int compare(Point q1, Point q2) {

            double slope1 = slopeTo(q1);
            double slope2 = slopeTo(q2);

            if (slope1 > slope2) {
                return 1;
            }
            if (slope1 < slope2) {
                return -1;
            }
            return 0;
        }
    }
}