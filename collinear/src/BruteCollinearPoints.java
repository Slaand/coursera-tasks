import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> segmentList = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {

        // finds all line segments containing 4 points
        Point[] aux = Arrays.copyOf(points, points.length);
        Arrays.sort(aux);
        int len = aux.length;

        // check for equals ??

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int m = k + 1; m < len; m++) {
                        // ????
                    }
                }
            }
        }
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