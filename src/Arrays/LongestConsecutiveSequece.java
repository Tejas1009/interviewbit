package Arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/?envType=problem-list-v2&envId=oizxjoit
 * 128. Longest Consecutive Sequence
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Example 3:
 * <p>
 * Input: nums = [1,0,1,2]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutiveSequece {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 1;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currLength = 1;
                while (set.contains(n + currLength)) {
                    currLength++;
                    result = Math.max(result, currLength);
                }
            }
        }
        return result;
    }
}
