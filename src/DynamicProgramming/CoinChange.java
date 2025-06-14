package DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/description/?envType=problem-list-v2&envId=oizxjoit
 * 322. Coin Change
 * Medium
 * Topics
 * Companies
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int currCoin : coins) {
                if (i - currCoin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - currCoin]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
