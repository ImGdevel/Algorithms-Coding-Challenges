import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        long x, y;
        Point(long x, long y) {
            this.x = x; this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if (this.x != o.x) return Long.compare(this.x, o.x);
            return Long.compare(this.y, o.y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while (c-- > 0) {
            int n = sc.nextInt();
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                points[i] = new Point(x, y);
            }

            Arrays.sort(points);

            boolean symmetric = true;
            long sumX = points[0].x + points[n - 1].x;
            long sumY = points[0].y + points[n - 1].y;

            for (int i = 1; i < n; i++) {
                long curX = points[i].x + points[n - 1 - i].x;
                long curY = points[i].y + points[n - 1 - i].y;
                if (curX != sumX || curY != sumY) {
                    symmetric = false;
                    break;
                }
            }

            System.out.println(symmetric ? "yes" : "no");
        }
    }
}
