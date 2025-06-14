package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 78. Subsets
 * Medium
 * Topics
 * Companies
 * Given an integer array nums of unique elements, return all possible
 * subsets
 * (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> res : result) {
            for (int n : res) {
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        dfs(nums, 0, result, new ArrayList<>(), visited);
        return result;
    }

    private static void dfs(int[] nums, int idx, List<List<Integer>> result, List<Integer> currElements, boolean visited[]) {
        result.add(new ArrayList<>(currElements));
        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) continue;
            currElements.add(nums[i]);
            visited[i] = true;
            dfs(nums, i + 1, result, currElements, visited);
            currElements.remove(currElements.size() - 1);
            visited[i] = false;
        }
    }
}
