package Greedy;

import java.util.Arrays;
import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * Medium
 * Topics
 * Companies
 * You are given m arrays, where each array is sorted in ascending order.
 * <p>
 * You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.
 * <p>
 * Return the maximum distance.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arrays = [[1,2,3],[4,5],[1,2,3]]
 * Output: 4
 * Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 * Example 2:
 * <p>
 * Input: arrays = [[1],[1]]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == arrays.length
 * 2 <= m <= 105
 * 1 <= arrays[i].length <= 500
 * -104 <= arrays[i][j] <= 104
 * arrays[i] is sorted in ascending order.
 * There will be at most 105 integers in all the arrays.
 */
public class MaxDistanceInArray {
    public static void main(String[] args) {
        List<List<Integer>> q = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(1, 2, 3));
        System.out.println(maxDistance(q));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, arrays.get(i).get(arrays.get(i).size() - 1) - min);
            result = Math.max(result, max - arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return result;
    }
}
