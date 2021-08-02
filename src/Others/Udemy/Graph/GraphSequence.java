package Others.Udemy.Graph;

/*
Graph sequence (Graph + DP)
Complete the following function which takes in an implicit graph (2D Matrix) and returns the length of longest increasing path sequence inside it.
A path can start from any node (x,y) and is increasing if each of its element is strictly greater than previous element.
(Assume - 4 way connectivity, each cell is connected with Top, Left, Up, & Down)
Sample Input:
[
[0,2,4,3,2]
[7,6,5,5,1]
[8,9,7,18,14]
[5,10,11,12,13]
]
Sample Output:
15
Explanation:
Look at the path staring from 1 and ending at 18 it has 15 nodes
Excepted Time Complexity: O(MN) where M is number of rows and N is the number of columns.
 */
public class GraphSequence {
    private static boolean visited[][];
    private static int dp[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    private static void dfs(int i, int j, int matrix[][]) {
        System.out.print(i + "-" + j + ", ");
        visited[i][j] = true;
        int cnt = 1;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && nj >= 0 && ni < matrix.length && nj < matrix[0].length && matrix[ni][nj] > matrix[i][j]) {
                if (!visited[ni][nj]) {
                    dfs(ni, nj, matrix);
                }
                cnt = Math.max(cnt, 1 + dp[ni][nj]);
            }
        }
        dp[i][j] = cnt;
        return;
    }

    public static int longestPathSequence(int matrix[][]) {
        visited = new boolean[matrix.length][matrix[0].length];
        dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Path from: " + i + "-" + j + ": ");
                dfs(i, j, matrix);
                res = Math.max(res, dp[i][j]);
                System.out.println();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {0, 2, 4, 3, 2},
                {7, 6, 5, 5, 1},
                {8, 9, 7, 18, 14},
                {5, 10, 11, 12, 13}
        };
        System.out.println(longestPathSequence(matrix));
    }
}
