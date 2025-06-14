package BackTracking;

import java.util.*;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 416. Partition Equal Subset Sum
 * Medium
 * Topics
 * Companies
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubSetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        //if the sum of all nums is odd then we cannot partition
        int target = Arrays.stream(nums).sum();
        if (target % 2 != 0) {
            return false;
        }
        //Add all possible combination of sum from nums so that if we find target/2 in set than we can partition the array
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> nextSet = new ArrayList<>();
            for (int n : set) {
                int newSum = n + nums[i];
                if (newSum == target / 2) {
                    return true;
                }
                nextSet.add(newSum);
            }
            set.addAll(nextSet);
        }
        return false;
    }
}
