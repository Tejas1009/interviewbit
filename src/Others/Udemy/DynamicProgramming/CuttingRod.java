package Others.Udemy.DynamicProgramming;

/*
Rod cutting Problem:
Find max profit.
 */
public class CuttingRod {
    public static int maxProfit_Recur(int prices[], int n) {
        if (n <= 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cut = i + 1;
            int curr_ans = prices[i] + maxProfit_Recur(prices, n - cut);
            res = Math.max(res, curr_ans);
        }
        return res;
    }

    public static int maxProfit_DP(int prices[], int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int len = 1; len <= n; len++) {
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                int cut = i + 1;
                int curr_ans = prices[i] + dp[len - cut];
                res = Math.max(res, curr_ans);
            }
            dp[len] = res;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxProfit_Recur(prices, 8));
        System.out.println("---------------------------");
        System.out.println(maxProfit_DP(prices, 8));
    }
}
