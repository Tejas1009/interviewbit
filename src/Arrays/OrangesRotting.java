package Arrays;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
public class OrangesRotting {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int freshOranges = 0, time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] currentOrange = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = currentOrange[0] + directions[i][0];
                    int nc = currentOrange[1] + directions[i][1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        return freshOranges <= 0 ? time : -1;
    }

    public int orangesRotting2(int[][] grid) {
        int rows = grid.length;       // Number of rows
        int cols = grid[0].length;    // Number of columns
        Queue<int[]> queue = new LinkedList<>(); // Queue for BFS
        int freshCount = 0;           // Count of fresh oranges
        int timeElapsed = 0;          // Time counter

        // Step 1: Initialize the queue with all initial rotten oranges
        // and count the number of fresh oranges.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    // Add rotten orange to the queue
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    // Count fresh orange
                    freshCount++;
                }
            }
        }

        // Directions for 4-neighbor cells (up, down, left, right)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Step 2: Perform BFS to rot adjacent fresh oranges
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();  // Number of rotten oranges to process at the current minute
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // Check all 4 possible directions
                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    // If the neighbor is a fresh orange, rot it
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // Mark as rotten
                        queue.offer(new int[]{nx, ny}); // Add to the queue
                        freshCount--; // Decrease fresh orange count
                    }
                }
            }
            timeElapsed++; // Increment time after processing a level
        }

        // Step 3: Check if there are still fresh oranges
        return freshCount == 0 ? timeElapsed : -1;
    }

}
