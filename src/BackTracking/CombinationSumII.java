package BackTracking;
/*Combination Sum II
        Asked in:
        Microsoft
        Amazon
        Infosys
        Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

        Each number in C may only be used once in the combination.

        Note:
        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        The solution set must not contain duplicate combinations.
        Example :

        Given candidate set 10,1,2,7,6,1,5 and target 8,

        A solution set is:

        [1, 7]
        [1, 2, 5]
        [2, 6]
        [1, 1, 6]
        Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
        Example : itertools.combinations in python.
        If you do, we will disqualify your submission retroactively and give you penalty points.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumII {
    ArrayList<ArrayList<Integer>> res;

    //10,1,2,7,6,1,5
    //1,1,2,5,6,7,10
    public void recur(ArrayList<Integer> a, int b, int asf, ArrayList<Integer> subSet, int x) {
        if (asf > b) {
            return;
        } else if (asf == b) {
            res.add(new ArrayList<>(subSet));
            return;
        } else {
            for (int i = x; i < a.size(); i++) {
                if (i > x && a.get(i).equals(a.get(i - 1))) {
                    continue;
                }
                subSet.add(a.get(i));
                recur(a, b, asf + a.get(i), subSet, i + 1);
                subSet.remove(subSet.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        res = new ArrayList<>();
        Collections.sort(a);
        recur(a, b, 0, new ArrayList<>(), 0);
        return res;
    }

    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        c.combinationSum(a, 8);
    }
}
