import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static long dist2(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            Point[] pts = new Point[4];
            for (int i = 0; i < 4; i++) {
                pts[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            List<Long> dists = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    dists.add(dist2(pts[i], pts[j]));
                }
            }

            Collections.sort(dists);

            if (dists.get(0) == 0) {
                System.out.println(0);
                continue;
            }

            boolean square =
                    dists.get(0).equals(dists.get(1)) &&
                    dists.get(1).equals(dists.get(2)) &&
                    dists.get(2).equals(dists.get(3)) &&
                    dists.get(4).equals(dists.get(5)) && 
                    !dists.get(0).equals(dists.get(4));

            System.out.println(square ? 1 : 0);
        }
    }
}
