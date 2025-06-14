package Arrays;

import java.util.*;

//https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = kClosest(points, k);
        for (int[] point : result) {
            System.out.println(String.format("%s - %s", point[0], point[1]));
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> (Double.compare(getDistance(p1), getDistance(p2))));
        for (int[] point : points) {
            pq.add(point);
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private static double getDistance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}
