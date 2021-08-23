package Others.Udemy.Hashing;

import java.util.HashMap;
import java.util.Map;
/*
Longest sub-array having sum k
Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.
Examples:
Input : arr[] = { 10, 5, 2, 7, 1, 9 },
            k = 15
Output : 4
The sub-array is {5, 2, 7, 1}.

Input : arr[] = {-5, 8, -14, 2, 4, 12},
            k = -5
Output : 5
 */

public class LongestSubArraySumK {
    /*
    Algorithm:
    We will use hashmap to store currsum i.e sum till now in the map with key as actual sum and value as index.
    Now, there will be 2 cases
        1) sum is equal to k
            -in that case we can directly compare res so far with actual length
        2) curr_sum - k is present in map
            -if present then we are sure that there exist a sum with k which starts after index of (curr_sum-k).
     */
    public static int longestSubarrayKSum(int arr[], int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int curr_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            if (curr_sum == k) {
                res = Math.max(res, i + 1);
            }
            if (!map.containsKey(curr_sum)) {
                map.put(curr_sum, i);
            }
            if (map.containsKey(curr_sum - k)) {
                if (res < (i - map.get(curr_sum - k))) {
                    res = i - map.get(curr_sum - k);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0, -2, 1, 2, 3, 4, 5, 15, 10, 5};
        int k = 15;
        System.out.println(longestSubarrayKSum(arr, k));
    }
}
