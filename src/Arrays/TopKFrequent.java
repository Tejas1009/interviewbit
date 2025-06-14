package Arrays;
//https://leetcode.com/problems/top-k-frequent-elements/description/?envType=problem-list-v2&envId=oizxjoit

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
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
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        int result[] = topKFrequent(nums, k);
        Arrays.stream(result).forEach(System.out::println);
    }

    static class Data implements Comparable<Data> {
        int num;
        int freq;

        Data(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Data o) {
            return o.freq - this.freq;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Data> priorityQueue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Data(entry.getKey(), entry.getValue()));
        }
        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            Data data = priorityQueue.poll();
            result[i] = data.num;
        }
        return result;
    }
}
