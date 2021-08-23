package Others.Udemy.Hashing;
/*
Counting Rectangle:
Given a N Cartesian Points in a 2D plane. find the number of
axis parallel rectangles that can be formed?

Sample Input:
[
    [0,0], [0,1], [1,1], [1,0], [2,1], [2,0], [3,1], [3,0]
]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Algorithm:
We can create a set and add all points to it.
We can consider any 2 points and find the remaining two diagonal points.
 */
public class CountingRectangles {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int countRectangles(List<Point> points) {
        int res = 0;
        Set<String> set = new HashSet<>();
        for (Point p : points) {
            set.add(p.x + "" + p.y);
        }

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                //check if p2 doesn't lie in same axis as p1's x or y
                //because we need to find a diagonal point
                Point p2 = points.get(j);
                if (p1.x == p2.x || p1.y == p2.y) {
                    continue;
                }
                Point p3 = new Point(p1.x, p2.y);
                Point p4 = new Point(p2.x, p1.y);
                if (set.contains(p3.x + "" + p3.y) && set.contains(p4.x + "" + p4.y)) {
                    res += 1;
                }
            }
        }
        return res / 2;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        points.add(new Point(1, 1));
        points.add(new Point(1, 0));
        points.add(new Point(2, 1));
        points.add(new Point(2, 0));
        points.add(new Point(3, 1));
        points.add(new Point(3, 0));
        System.out.println(countRectangles(points));
    }
}
