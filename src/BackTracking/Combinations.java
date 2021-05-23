package BackTracking;

import java.util.ArrayList;

public class Combinations {

    public void allCombinations(String osf, int n, int k, int x, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset) {
        if (subset.size() == k) {
            //System.out.println(osf);
            /*ArrayList<Integer> r = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                r.add(Integer.parseInt(String.valueOf(osf.charAt(j))));
            }*/
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int i = x; i <= n; i++) {
            subset.add(i);
            allCombinations(osf + i, n, k, i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        allCombinations("", n, k, 1, res, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4, 2);
    }
}
