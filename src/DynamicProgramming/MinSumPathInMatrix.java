package DynamicProgramming;

/*Min Sum Path in Matrix
        Asked in:
        Amazon
        Problem Description

        Given a 2D integer array A of size M x N, you need to find a path from top left to bottom right which minimizes the sum of all numbers along its path.

        NOTE: You can only move either down or right at any point in time.



        Input Format
        First and only argument is an 2D integer array A of size M x N.



        Output Format
        Return a single integer denoting the minimum sum of a path from cell (1, 1) to cell (M, N).



        Example Input
        Input 1:

        A = [  [1, 3, 2]
        [4, 3, 1]
        [5, 6, 1]
        ]


        Example Output
        Output 1:

        9


        Example Explanation
        Explanation 1:

        The path is 1 -> 3 -> 2 -> 1 -> 1
        So ( 1 + 3 + 2 + 1 + 1) = 8*/
public class MinSumPathInMatrix {

    private void recur(int arr[][], int i, int j, int r, int c, int sum) {
        if (i == r && j == c) {
            System.out.println(sum);
        }
        if (i > r || j > c) return;
        sum = sum + arr[i][j];
        recur(arr, i, j + 1, r, c, sum);
        recur(arr, i + 1, j, r, c, sum);
    }


    private int solveUsingDp(int dp[][], int r, int c) {
        for (int i = 1; i < r; i++) dp[i][0] = dp[i - 1][0] + dp[i][0];
        for (int i = 1; i < c; i++) dp[0][i] = dp[0][i - 1] + dp[0][i];
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[r - 1][c - 1];
    }

    public int minPathSum(int arr[][]) {
        //recur(arr, 0, 0, arr.length - 1, arr[0].length - 1, arr[0][0]);
        int res = solveUsingDp(arr, arr.length, arr[0].length);
        return res;
    }

    public static void main(String[] args) {
        MinSumPathInMatrix m = new MinSumPathInMatrix();
        int arr[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.println(m.minPathSum(arr));
    }
}
