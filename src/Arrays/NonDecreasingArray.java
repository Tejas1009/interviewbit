package Arrays;
//https://leetcode.com/problems/non-decreasing-array/description/

/**
 * 665. Non-decreasing Array
 * Medium
 * Topics
 * Companies
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * <p>
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You cannot get a non-decreasing array by modifying at most one element.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        boolean changed = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            if (changed) {
                return false;
            }
            if (i == 0) {
                nums[i] = nums[i + 1];
            } else if (nums[i + 1] < nums[i - 1]) {
                nums[i + 1] = nums[i];
            } else {
                nums[i] = nums[i + 1];
            }
            changed = true;
        }
        return true;
    }
}
