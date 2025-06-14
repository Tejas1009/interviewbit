package DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Medium
 * Topics
 * Companies
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 * <p>
 * Input: prices = [1]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class BestTimeToBuySellStockCollDown {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(0, true, prices, dp);
    }

    private static int dfs(int i, boolean buying, int[] prices, int dp[][]) {
        if (i >= prices.length) {
            return 0;
        }
        int i2 = buying ? 1 : 0;
        if (dp[i][i2] != -1) {
            return dp[i][i2];
        }
        int profit = 0;
        if (buying) {
            int buy = -prices[i] + dfs(i + 1, false, prices, dp);
            int coolDown = profit + dfs(i + 1, true, prices, dp);
            profit = Math.max(buy, coolDown);
        } else {
            int sell = prices[i] + dfs(i + 2, true, prices, dp);
            int coolDown = profit + dfs(i + 1, false, prices, dp);
            profit = Math.max(sell, coolDown);
        }
        dp[i][i2] = profit;
        return profit;
    }
}
