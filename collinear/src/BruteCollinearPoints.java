import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> segmentList;

    public BruteCollinearPoints(Point[] points) {

        if(points == null) {
            throw new IllegalArgumentException();
        }

        // finds all line segments containing 4 points

        segmentList = new ArrayList<>();
        Point[] save = new Point[points.length];
        int length = save.length;
        System.arraycopy(points, 0, save, 0, length);

        for(int k=1; k<length; k++) {
            if(save[k].compareTo(save[k-1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    for (int m = k + 1; m < length; m++) {
                        Point p1 = save[i], p2 = save[j], p3 = save[k], p4 = save[m];
                        if((p1.slopeTo(p2) == p2.slopeTo(p3)) && (p2.slopeTo(p3) == p3.slopeTo(p4))) {
                            segmentList.add(new LineSegment(p1, p4));
                            p1.drawTo(p4);
                        }
                    }
                }
            }
        }

        //TODO inf loop fix
        System.out.println(numberOfSegments());

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