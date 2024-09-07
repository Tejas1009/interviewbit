package TwoPointer;

import java.util.Arrays;
import java.util.Collections;

/**
 * 1838. Frequency of the Most Frequent Element
 * Medium
 * Topics
 * Companies
 * Hint
 * The frequency of an element is the number of times it occurs in an array.
 * <p>
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 * <p>
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * Example 2:
 * <p>
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 * Example 3:
 * <p>
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 */
public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int arr[] = {1, 4, 8, 13};
        int k = 5;
        System.out.println(maxFrequency(arr, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        if (nums.length <= 1) return nums.length;
        int result = 1;
        Arrays.sort(nums);
        int right = nums.length - 1, left = nums.length - 2;
        int units = k;
        while (right >= 0) {
            int currentResult = 1;
            while (left >= 0 && units > 0) {
                int requiredUnits = Math.abs(nums[right] - nums[left]);
                if (units >= requiredUnits) {
                    units -= requiredUnits;
                    currentResult = Math.max(currentResult, right - left + 1);
                }
                left--;
            }
            result = Math.max(result, currentResult);
            right--;
            left = right - 1;
            units = k;
        }
        return result;
    }
}
