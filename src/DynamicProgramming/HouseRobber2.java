package DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber-ii/description/?envType=problem-list-v2&envId=oizxjoit
 * <p>
 * 213. House Robber II
 * Medium
 * Topics
 * Companies
 * Hint
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] houseArrayWithoutLastHouse = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] houseArrayWithoutFirstHouse = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(getMaxRobValue(houseArrayWithoutLastHouse), getMaxRobValue(houseArrayWithoutFirstHouse));
    }

    private static int getMaxRobValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }
}
