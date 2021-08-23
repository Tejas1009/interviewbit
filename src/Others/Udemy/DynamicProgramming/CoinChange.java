package Others.Udemy.DynamicProgramming;

/*
Coin Change:
Given an array of coin denominations, and an integer M representing target money.
We need to find the minimum coins required to make the changes.
Input: [1,3,7,10]
M = 15
Output: 3 (7+7+1)
 */
public class CoinChange {
    public static int minNumberOfCoinsForChange(int coins[], int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int coins[] = {1, 3, 7, 10};
        System.out.println(minNumberOfCoinsForChange(coins, 15));
    }
}
