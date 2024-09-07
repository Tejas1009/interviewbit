package Graph;

/**
 * 1905. Count Sub Islands
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 * <p>
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 * <p>
 * Return the number of islands in grid2 that are considered sub-islands.
 */
public class CountSubIslands {

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int grid1[][] = new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int grid2[][] = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands(grid1, grid2));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;
        boolean visited[][] = new boolean[rows][cols];
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    if (dfs(i, j, grid1, grid2, visited, rows, cols)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static boolean dfs(int i, int j, int[][] grid1, int[][] grid2, boolean visited[][], int rows, int cols) {
        visited[i][j] = true;
        boolean isIsLand = true;
        if (grid1[i][j] == 0) {
            isIsLand = false;
        }
        for (int[] direction : directions) {
            int newR = direction[0] + i;
            int newC = direction[1] + j;
            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && !visited[newR][newC] && grid2[newR][newC] == 1) {
                boolean res = dfs(newR, newC, grid1, grid2, visited, rows, cols);
                isIsLand = res && isIsLand;
            }
        }
        return isIsLand;
    }
}
