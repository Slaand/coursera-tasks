import java.util.ArrayList;

public class FastCollinearPoints {

    private ArrayList<LineSegment> segmentList = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {

        // System.out.println(points.length);
        // finds all line segments containing 4 or more points
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