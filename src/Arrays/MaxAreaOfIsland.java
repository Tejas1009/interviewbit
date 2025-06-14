package Arrays;

public class MaxAreaOfIsland {
    public static void main(String[] args) {

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int currArea = dfs(grid, i, j, visited);
                area = Math.max(area, currArea);
            }
        }
        return area;
    }

    private static int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if ((r < 0) || (r >= grid.length) || (c < 0) || (c >= grid[0].length) || (grid[r][c] == 0) || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        return 1 + dfs(grid, r + 1, c, visited)
                + dfs(grid, r - 1, c, visited)
                + dfs(grid, r, c + 1, visited)
                + dfs(grid, r, c - 1, visited);
    }

}
