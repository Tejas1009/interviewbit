package Others.Udemy.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {

    public static ArrayList<Integer> pairSum(ArrayList<Integer> arr, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            int x = sum - arr.get(i);
            if (set.contains(x)) {
                res.add(x);
                res.add(arr.get(i));
                return res;
            }
            set.add(arr.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 5, 2, 3, -6, 9, 11));
        pairSum(arr, 4).forEach(System.out::println);
    }
}
