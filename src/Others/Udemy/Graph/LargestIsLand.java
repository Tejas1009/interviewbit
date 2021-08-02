package Others.Udemy.Graph;

/*
Largest Island:
You are given a two dimensional grid, containing only 0 and 1's. s. Each 1 represents land, and 0 represents water.
The adjacent 1s form an island. Each land piece (x,y) is connected to its 4 neighbours (Left, Right, Up and Down).
Your task is to find the size of largest island - size of island is given by number of 1s in that island.
Your code should return 0 is no island is present.
 */
public class LargestIsLand {
    private static int max_island_size = 0;
    private static boolean visited[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    private static void dfs(int i, int j, int grid[][], int isf) {
        max_island_size = Math.max(isf, max_island_size);
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && !visited[ni][nj] && grid[ni][nj] == 1) {
                dfs(ni, nj, grid, isf + 1);
            }
        }
    }

    public static int largest_island(int grid[][]) {
        max_island_size = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, 1);
                }
            }
        }
        return max_island_size;
    }

    public static void main(String[] args) {
        int grid[][] = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0}
        };
        System.out.println(largest_island(grid));
        System.out.println("--------------------------");
        int grid2[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(largest_island(grid2));
    }
}