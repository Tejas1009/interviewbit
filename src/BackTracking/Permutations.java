package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a collection of numbers, return all possible permutations.

        Example:

        [1,2,3] will have the following permutations:

        [1,2,3]
        [1,3,2]
        [2,1,3]
        [2,3,1]
        [3,1,2]
        [3,2,1]
        NOTE
        No two entries in the permutation sequence should be the same.
        For the purpose of this problem, assume that all the numbers in the collection are unique.*/
public class Permutations {

    private void permutations(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ds, boolean[] freq) {
        if (ds.size() == arr.size()) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr.get(i));
                permutations(arr, res, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (arr.size() <= 1) {
            res.add(new ArrayList<>(arr));
            return res;
        }
        boolean freq[] = new boolean[arr.size()];
        permutations(arr, res, new ArrayList<>(), freq);

        return res;
    }


    public static void main(String[] args) {
        Permutations p = new Permutations();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(p.permute(arr));
    }
}
