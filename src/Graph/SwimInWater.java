package Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/swim-in-rising-water/
 * <p>
 * 778. Swim in Rising Water
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
 * <p>
 * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 * <p>
 * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation: The final route is shown.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 */
public class SwimInWater {
    public static void main(String[] args) {
        int[][] grid = {{0}};
        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {
        PriorityQueue<Data> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.elevation));
        minHeap.add(new Data(grid[0][0], 0, 0));
        boolean[][] visited = new boolean[grid.length][grid.length];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[0][0] = true;
        int result = -1;
        while (!minHeap.isEmpty()) {
            Data data = minHeap.poll();
            if (data.r == grid.length - 1 && data.c == grid.length - 1) {
                return Math.max(result, data.elevation);
            }
            for (int[] direction : directions) {
                int newR = data.r + direction[0];
                int newC = data.c + direction[1];
                if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid.length || visited[newR][newC]) {
                    continue;
                }
                visited[newR][newC] = true;
                int newElevation = Math.max(data.elevation, grid[newR][newC]);
                Data neighbour = new Data(newElevation, newC, newR);
                minHeap.add(neighbour);
            }
        }
        return result;
    }

    public static class Data {
        int elevation;
        int r;
        int c;

        public Data(int elevation, int c, int r) {
            this.elevation = elevation;
            this.c = c;
            this.r = r;
        }
    }
}
