import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

    private ArrayList<LineSegment> segmentList = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {

        if (points == null) {
            throw new IllegalArgumentException();
        }

        int length = points.length;
        Point[] save = new Point[length];
        System.arraycopy(points, 0, save, 0, length);

        for (int k = 1; k < length; k++) {

            if (save[k].compareTo(save[k - 1]) == 0) {
                throw new IllegalArgumentException();
            }

            if (save[k - 1] == null) {
                throw new IllegalArgumentException();
            }
        }

        for (Point p : points) {

            Arrays.sort(save);
            Arrays.sort(save, p.slopeOrder());

            int min = 0;
            while (min < save.length && p.slopeTo(save[min]) == Double.NEGATIVE_INFINITY) min++;
            int max = min;

            while (min < save.length) {
                while (max < save.length && p.slopeTo(save[max]) == p.slopeTo(save[min])) max++;
                if (max - min >= 3) {
                    Point pMin = save[min].compareTo(p) < 0 ? save[min] : p;
                    Point pMax = save[max - 1].compareTo(p) > 0 ? save[max - 1] : p;
                    if (p == pMin) {
                        segmentList.add(new LineSegment(pMin, pMax));
                    }
                }
                min = max;
            }
        }
    }

    public int numberOfSegments() { return segmentList.size(); }

    public LineSegment[] segments() {
        LineSegment[] segments = new LineSegment[segmentList.size()];
        return segmentList.toArray(segments);
    }
}