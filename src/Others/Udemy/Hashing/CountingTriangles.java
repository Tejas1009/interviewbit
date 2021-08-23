package Others.Udemy.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Counting Triangles:
Given N cartesian Points in a 2D plane, find the number of triangles such that the base of
or perpendicular is parallel to the X or Y-axis.
Sample Input:
[(0,0), (2,0), (0,1)]
Output:
1

Sample Input:
[(1,2),(2,0),(2,2),(2,3),(4,2)]
Output:
4
 */
public class CountingTriangles {
    /*
    Algorithm:
    Count no. of same x-axis point and no. of y same y-axis point excluding self.
    add product of both to result.
     */
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int countTriangles(List<Point> points) {
        int res = 0;
        Map<Integer, Integer> x_map = new HashMap<>();
        Map<Integer, Integer> y_map = new HashMap<>();
        for (Point p : points) {
            x_map.putIfAbsent(p.x, 0);
            x_map.put(p.x, x_map.get(p.x) + 1);
            y_map.putIfAbsent(p.y, 0);
            y_map.put(p.y, y_map.get(p.y) + 1);
        }
        for (Point p : points) {
            int x_point_freq = x_map.get(p.x) - 1;
            int y_point_freq = y_map.get(p.y) - 1;
            res += (x_point_freq * y_point_freq);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(2, 0));
        points.add(new Point(2, 2));
        points.add(new Point(2, 3));
        points.add(new Point(4, 2));
        System.out.println(countTriangles(points));
        System.out.println("------------------");
        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(0, 0));
        points2.add(new Point(2, 0));
        points2.add(new Point(0, 1));
        System.out.println(countTriangles(points2));
    }
}
