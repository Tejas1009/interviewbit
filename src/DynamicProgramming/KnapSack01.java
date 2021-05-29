package DynamicProgramming;

public class KnapSack01 {

    public int solve(int[] p, int[] wt, int c) {
        int dp[][] = new int[p.length + 1][c + 1];
        for (int i = 1; i <= p.length; i++) {
            for (int j = 1; j <= c; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], p[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return dp[wt.length][c];
    }

    public static void main(String[] args) {
        KnapSack01 k = new KnapSack01();
        int p[] = {359, 963, 465, 706, 146, 282, 828, 962, 492};
        int wt[] = {96, 43, 28, 37, 92, 5, 3, 54, 93};
        System.out.println(k.solve(p, wt, 383));
    }
}
