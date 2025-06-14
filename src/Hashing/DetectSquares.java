package Hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/detect-squares/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 2013. Detect Squares
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a stream of points on the X-Y plane. Design an algorithm that:
 * <p>
 * Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
 * Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
 * An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.
 * <p>
 * Implement the DetectSquares class:
 * <p>
 * DetectSquares() Initializes the object with an empty data structure.
 * void add(int[] point) Adds a new point point = [x, y] to the data structure.
 * int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.
 */
public class DetectSquares {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private List<Pair> coordinates;
    private Map<String, Integer> map;

    public DetectSquares() {
        coordinates = new ArrayList<>();
        map = new HashMap<>();
    }

    public void add(int[] point) {
        coordinates.add(new Pair(point[0], point[1]));
        String key = point[0] + "-" + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0];
        int y = point[1];
        for (Pair pair : coordinates) {
            if (pair.x == x || pair.y == y) {
                continue;
            }
            if (Math.abs(pair.x - x) == Math.abs(pair.y - y)) { //check for diagonal of given input
                String diag1 = pair.x + "-" + y;
                String diag2 = x + "-" + pair.y;
                res += map.getOrDefault(diag1, 0) *
                        map.getOrDefault(diag2, 0);//check for other 2 diagonal & multiply them so that if there are multiple points we can consider them that many times
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DetectSquares ds = new DetectSquares();
        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});
        System.out.println(ds.count(new int[]{11, 10}));
    }
}
