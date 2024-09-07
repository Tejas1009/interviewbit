package Graph;

import java.util.*;

/**
 * 200. Number of Islands
 * Medium
 * Topics
 * Companies
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char grid[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int numIslands(char[][] grid) {
        int islands = 0;
        int row = grid.length, col = grid[0].length;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    islands++;
                    visited.add(i + "," + j);
                    bfs(i, j, visited, row, col, grid);
                }
            }
        }
        return islands;
    }

    private static void bfs(int r, int c, Set<String> visited, int rows, int cols, char[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(r, c));
        while (!queue.isEmpty()) {
            List<Integer> currentNode = queue.poll();
            for (int[] direction : directions) {
                int nr = currentNode.get(0) + direction[0];
                int nc = currentNode.get(1) + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
                    queue.add(Arrays.asList(nr, nc));
                    visited.add(nr + "," + nc);
                }
            }
        }
    }
}
