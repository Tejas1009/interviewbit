package Others.Udemy.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithTargetSum {
    public static int cntSubArrays(int arr[], int k) {
        //we will calculate a prefix sum at each index
        //and we will store it in a set

        //Algorithm:
        //if current prefix sum is equal to k then simply increment res
        //if current prefix sum - k is present in set them increment the res
        int res = 0, prefix_sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];
            if (prefix_sum == k) {
                res++;
            }
            if (set.contains(prefix_sum - k)) {
                res++;
            }
            set.add(prefix_sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(cntSubArrays(arr, 7));
        int arr1[] = {10, 2, -2, -20, 10};
        System.out.println(cntSubArrays(arr1, -10));
    }
}