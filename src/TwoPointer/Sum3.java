package TwoPointer;

import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
        Return the sum of the three integers.

        Assume that there will only be one solution

        Example:
        given array S = {-1 2 1 -4},
        and target = 1.

        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)*/
public class Sum3 {
    public int threeSumClosest(int[] arr, int m) {
        if (arr.length < 3) {
            return m;
        }
        int n = arr.length, best = arr[0] + arr[1] + arr[n - 1];
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == m) {
                    return m;
                }
                if (sum < m) {
                    j++;
                } else {
                    k--;
                }
                if (Math.abs(m - sum) < Math.abs(best - m)) {
                    best = sum;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Sum3 s = new Sum3();
        //int arr[] = {2, 1, -9, -7, -8, 2, -8, 2, 3, -8};//-1//-2
        int arr[] = {-10, -10, -10};//3
        //3
        //ans-2
        s.threeSumClosest(arr, -5);
    }
}