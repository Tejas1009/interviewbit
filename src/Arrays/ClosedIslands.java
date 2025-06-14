package Arrays;

/**
 * https://leetcode.com/problems/number-of-closed-islands/description/
 * <p>
 * 1254. Number of Closed Islands
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 */
public class ClosedIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    res += dfs(i, j, grid, visited);
                }
            }
        }
        return res;
    }

    private static int dfs(int r, int c, int[][] grid, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }
        //checking for water in surrounding
        if (grid[r][c] == 1 || visited[r][c]) {
            return 1;
        }
        visited[r][c] = true;
        return dfs(r + 1, c, grid, visited) *
                dfs(r - 1, c, grid, visited) *
                dfs(r, c + 1, grid, visited) *
                dfs(r, c - 1, grid, visited);
    }
}
