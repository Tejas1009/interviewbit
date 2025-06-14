package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 46. Permutations
 * Medium
 * Topics
 * Companies
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> res : result) {
            for (int n : res) {
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        permutate(nums, 0, result, new ArrayList<>(), taken);
        return result;
    }

    private static void permutate(int[] nums, int idx, List<List<Integer>> result, List<Integer> currElements, boolean[] taken) {
        if (currElements.size() == nums.length) {
            result.add(new ArrayList<>(currElements));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (taken[i]) continue;
            currElements.add(nums[i]);
            taken[i] = true;
            permutate(nums, i, result, currElements, taken);
            taken[i] = false;
            currElements.remove(currElements.size() - 1);
        }
    }
}
