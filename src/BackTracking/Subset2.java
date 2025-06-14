package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * Medium
 * Topics
 * Companies
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
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
 */
public class Subset2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        for (List<Integer> res : result) {
            for (int n : res) {
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void subset(int[] nums, int x, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = x; i < nums.length; i++) {
            if (i > x && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            subset(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}