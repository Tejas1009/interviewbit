package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/?envType=problem-list-v2&envId=oizxjoit
 * 39. Combination Sum
 * Medium
 * Topics
 * Companies
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        result.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, 0, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> result, int currSum, List<Integer> currList, int start) {
        if (currSum == target) {
            //currList.stream().forEach(x -> System.out.print(x));
            result.add(new ArrayList<>(currList));
            return;
        }
        if (currSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            currList.add(candidates[i]);
            dfs(candidates, target, result, currSum + candidates[i], currList, i);
            currList.remove(currList.size() - 1);
        }
    }
}
