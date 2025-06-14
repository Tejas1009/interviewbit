package DynamicProgramming;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=problem-list-v2&envId=plakya4j
 * 746. Min Cost Climbing Stairs
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 * <p>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        //compute second last min cost
        cost[cost.length - 2] = Math.min(cost[cost.length - 2] + cost[cost.length - 2], cost[cost.length - 2]);
        for (int i = cost.length - 3; i >= 0; i--) {
            int oneStep = cost[i] + cost[i + 1];
            int twoStep = cost[i] + cost[i + 2];
            cost[i] = Math.min(oneStep, twoStep);
        }
        return Math.min(cost[0], cost[1]);
    }
}
