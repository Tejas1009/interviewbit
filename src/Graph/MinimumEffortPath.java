package Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/description/
 * <p>
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * <p>
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * <p>
 * <p>
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 */
public class MinimumEffortPath {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int heights[][] = {{1, 10, 6, 7, 9, 10, 4, 9}};
        System.out.println(minimumEffortPath(heights));
    }

    static class Tuple {
        private int row;
        private int column;
        private int distance;

        public Tuple(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    public static int minimumEffortPath(int[][] heights) {
        int result = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        while (!pq.isEmpty()) {
            Tuple currNode = pq.remove();
            int distance = currNode.distance;
            int row = currNode.row;
            int col = currNode.column;
            for (int i = 0; i < 4; i++) {
                int nr = row + directions[i][0];
                int nc = col + directions[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nr][nc]), distance);
                    if (effort < dist[nr][nc]) {
                        dist[nr][nc] = effort;
                        pq.add(new Tuple(nr, nc, effort));
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
