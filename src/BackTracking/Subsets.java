package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr.size() <= 0) {
            return result;
        }
        Collections.sort(arr);
        findAllSubsets(arr, result, new ArrayList<>(), 0);
        return result;
    }

    private void findAllSubsets(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int startIdx) {
        result.add(new ArrayList<>(subset));
        for (int i = startIdx; i < arr.size(); i++) {
            subset.add(arr.get(i));
            findAllSubsets(arr, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        ArrayList<Integer> ip = new ArrayList<>(Arrays.asList(1, 2, 3));
        s.subsets(ip);
    }
}
