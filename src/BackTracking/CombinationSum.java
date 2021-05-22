package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

        The same repeated number may be chosen from C unlimited number of times.

        Note:
        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        The combinations themselves must be sorted in ascending order.
        CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
        The solution set must not contain duplicate combinations.
        Example,
        Given candidate set 2,3,6,7 and target 7,
        A solution set is:

        [2, 2, 3]
        [7]*/
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        helper(A, ans, new ArrayList<>(), B, 0);
        return new ArrayList<>(ans);
    }

    private void helper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int b, int idx) {
        if (b < 0) {
            return;
        }
        if (b == 0) {
            if(!ans.contains(curr)) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = idx; i < a.size(); i++) {
            curr.add(a.get(i));
            helper(a, ans, curr, b - a.get(i), i);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        cs.combinationSum(arr, 28);
    }
}
