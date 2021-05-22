package Hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*Find the largest continuous sequence in a array which sums to zero.

        Example:


        Input:  {1 ,2 ,-2 ,4 ,-4}
        Output: {2 ,-2 ,4 ,-4}

        NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.*/
public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0, len = 0, startIdx = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > len) {
                    len = i - map.get(sum);
                    startIdx = map.get(sum);
                }
            }
            if (sum == 0) {
                if (i > len) {
                    len = i + 1;
                    startIdx = -1;
                }
            }
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        for (int i = startIdx + 1; i <= startIdx + len; i++) {
            res.add(arr.get(i));
        }
        if (res.size() <= 0 && map.containsKey(0)) res.add(map.get(0));
        return res;
    }

    public static void main(String[] args) {
        LargestContinuousSequenceZeroSum l = new LargestContinuousSequenceZeroSum();
        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 22, 7, 21, -11, -6, -7, -16, -2));
        l.lszero(arr);
    }
}