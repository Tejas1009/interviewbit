package DynamicProgramming;

public class EggDropProblem {

    public int solveUsingDP(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];
        for (int i = 1; i <= f; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= e; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    int max = Math.max(dp[i - 1][k], dp[i][j - k - 1]);
                    min = Math.min(max, min);
                }
                dp[i][j] = 1 + min;
            }
        }
        return dp[e][f];
    }

    public int solve(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];
        for (int i = 1; i <= f; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= e; i++) {
            dp[i][1] = 1;
        }
        int low = 0, high = 0;
        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                if (i > j)             //cosidering worst case scenario
                {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                int t = Integer.MAX_VALUE;
                low = 1;
                high = j;
                while (low + 1 < high) {
                    int mid = (low + high) / 2;
                    if (dp[i - 1][mid - 1] < dp[i][j - mid])
                        low = mid;
                    else if (dp[i - 1][mid - 1] > dp[i][j - mid])
                        high = mid;
                    else
                        high = low = mid;
                }
                t = 1 + Math.min(Math.max(dp[i - 1][low - 1], dp[i][j - low]), Math.max(dp[i - 1][high - 1], dp[i][j - high]));
                dp[i][j] = t;
            }
        }
        return dp[e][f];
    }


    public static void main(String[] args) {
        EggDropProblem e = new EggDropProblem();
        //System.out.println(e.solveUsingDP(1, 2));
        System.out.println(e.solve(2, 10));
    }
}