package BinarySearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/?envType=problem-list-v2&envId=binary-search
 * 81. Search in Rotated Sorted Array II
 * Medium
 * Topics
 * Companies
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * <p>
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 * <p>
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 * <p>
 * You must decrease the overall operation steps as much as possible.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */
public class RotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[low] && nums[high] == nums[mid]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
