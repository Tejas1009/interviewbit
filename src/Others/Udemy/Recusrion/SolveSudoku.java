package Others.Udemy.Recusrion;

public class SolveSudoku {

    private static boolean solveSudoku(int mat[][], int n, int i, int j) {
        //base case
        if (i == n) {
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    System.out.print(mat[x][y] + " ");
                }
                System.out.println();
            }
            return true;
        }
        if (j == n) {
            return solveSudoku(mat, n, i + 1, 0);
        }
        if (mat[i][j] != 0) {
            return solveSudoku(mat, n, i, j + 1);
        }
        //rec case
        //cell to be filled
        //try out all possibilities
        for (int k = 1; k <= 9; k++) {
            if (isSafe(mat, i, j, k)) {
                mat[i][j] = k;
                boolean solveProblem = solveSudoku(mat, n, i, j + 1);
                if (solveProblem) {
                    return true;
                }
            }
        }
        mat[i][j] = 0;
        return false;
    }

    static boolean isSafe(int[][] grid, int row, int col,
                          int num) {

        // Check if we find the same num
        // in the similar row , we
        // return false
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;

        // Check if we find the same num
        // in the similar column ,
        // we return false
        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == num)
                return false;

        // Check if we find the same num
        // in the particular 3*3
        // matrix, we return false
        int startRow = row - row % 3, startCol
                = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

    private static boolean isSafe(int mat[][], int n, int i, int j, int k) {
        for (int x = 0; x < 9; x++) {
            if (mat[i][x] == k || mat[x][j] == k) {
                return false;
            }
        }
        int sx = (i / 3) * 3;
        int sy = (j / 3) * 3;
        for (int x = sx; x < sx + 3; x++) {
            for (int y = sy; y < sy + 3; y++) {
                if (mat[x][y] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solve(int mat[][]) {
        return solveSudoku(mat, 9, 0, 0);
    }

    public static void main(String[] args) {
        int mat[][] = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        System.out.println(solve(mat));
    }
}