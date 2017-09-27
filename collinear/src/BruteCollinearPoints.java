import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> segmentList = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {

        if (points == null) {
            throw new IllegalArgumentException();
        }

        int length = points.length;
        Point[] save = new Point[length];
        System.arraycopy(points, 0, save, 0, length);

        Arrays.sort(save);

        for (int k = 1; k < length; k++) {

            if (save[k].compareTo(save[k - 1]) == 0) {
                throw new IllegalArgumentException();
            }

            if (save[k - 1] == null) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    for (int m = k + 1; m < length; m++) {
                        Point p1 = save[i], p2 = save[j], p3 = save[k], p4 = save[m];
                        if ((p1.slopeTo(p2) == p1.slopeTo(p3)) && (p1.slopeTo(p2) == p1.slopeTo(p4))) {
                            segmentList.add(new LineSegment(p1, p4));
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() { return segmentList.size(); }

    public LineSegment[] segments() {
        LineSegment[] segments = new LineSegment[segmentList.size()];
        return segmentList.toArray(segments);
    }
}