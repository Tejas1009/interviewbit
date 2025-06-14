package BinarySearch;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=oizxjoit

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Medium
 * Topics
 * Companies
 * Hint
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * Example 3:
 * <p>
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {3, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int m = findPeakIndex(nums);
        int r = nums.length - 1;
        if (nums[m] >= nums[r]) {
            return nums[m + 1];
        }
        return nums[0];
    }

    private static int findPeakIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return (l + r) / 2;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (m == nums.length - 1) {
                return (l + r) / 2;
            }
            if ((m == 0 || nums[m - 1] < nums[m]) && (m == nums.length - 1 || nums[m] > nums[m + 1])) {
                return m;
            }
            if (nums[m] < nums[l]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (l + r) / 2;
    }
}
