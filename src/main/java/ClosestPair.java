import java.util.*;

public class ClosestPair {

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static double closestPair(Point[] points) {
        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));
        return closestPairRecursive(points, 0, points.length - 1);
    }

    private static double closestPairRecursive(Point[] points, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        double leftDist = closestPairRecursive(points, left, mid);
        double rightDist = closestPairRecursive(points, mid + 1, right);
        double minDist = Math.min(leftDist, rightDist);

        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDist) {
                strip.add(points[i]);
            }
        }

        return Math.min(minDist, stripClosest(strip, minDist));
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double min = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                min = Math.min(min, distance(points[i], points[j]));
            }
        }
        return min;
    }

    private static double stripClosest(List<Point> strip, double d) {
        double min = d;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; j++) {
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
            }
        }
        return min;
    }

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point[] points = { new Point(0, 0), new Point(1, 1), new Point(3, 3), new Point(6, 6) };
        System.out.println("Closest Pair Distance: " + closestPair(points));
    }
}
