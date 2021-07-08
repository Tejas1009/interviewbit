package Others.Udemy.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestBandCode {
    //1,9,3,0,18,5,2,4,10,7,12,6
    public static int longestChain(int arr[]) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] - 1)) {
                continue;
            }
            int current_length = 1, j = arr[i] + 1;
            while (set.contains(j)) {
                current_length++;
                j++;
            }
            res = Math.max(res, current_length);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(longestChain(arr));
    }
}