package TwoPointer;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 * Hard
 * Topics
 * Companies
 * Hint
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSLidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            int currElement = nums[r];
            while (!deque.isEmpty() && currElement > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(r);
            if ((r - l) + 1 == k) {
                result.add(nums[deque.peekFirst()]);
                if (deque.peekFirst() != null && deque.peekFirst() == l) {
                    deque.pollFirst();
                }
                l++;
            }
            r++;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
