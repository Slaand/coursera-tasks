import java.util.ArrayList;
import java.util.Comparator;

public class FastCollinearPoints {

    private ArrayList<LineSegment> segmentList;

    public FastCollinearPoints(Point[] points) {

        if(points == null) {
            throw new IllegalArgumentException();
        }

        int length = points.length;
        segmentList = new ArrayList<>();
        Point[] save = new Point[length];
        System.arraycopy(points, 0, save, 0, length);

        for(int k=1; k<length; k++) {
            if(save[k].compareTo(save[k-1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

        // sorting ???

        // finds all line segments containing 4 or more points
    }

    private static void merge(Point[] a, Point[] aux, int lo, int mid, int hi, Comparator<Point> comparator)
    {

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(comparator, aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    private static void sort(Point[] a, Point[] aux, int lo, int hi, Comparator<Point> comparator)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, comparator);
        sort(a, aux, mid+1, hi, comparator);
        // if (!less(a[mid+1], a[mid])) return;
        merge(a, aux, lo, mid, hi, comparator);
    }

    private static boolean less(Comparator<Point> comparator, Point v, Point w) {
        return comparator.compare(v, w) < 0;
    }

    public int numberOfSegments() {

        // the number of line segments
        return segmentList.size();
    }

    public LineSegment[] segments() {

        // the line segments
        LineSegment[] segments = new LineSegment[segmentList.size()];
        return segmentList.toArray(segments);
    }
}