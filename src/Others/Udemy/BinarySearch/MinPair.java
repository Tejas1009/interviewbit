package Others.Udemy.BinarySearch;
/*
Given two non-empty arrays, find the pair of numbers
(one from each arrays) whose absolute difference is
minimum. Print the any one pair with the smallest difference.
 */

import java.util.Arrays;

public class MinPair {

    //ar1: {-1,5,10,20,3}
    //arr2: {26,134,135,15,17}
    public static void minPair(int arr1[], int arr2[]) {
        Arrays.sort(arr2);
        int diff = Integer.MAX_VALUE, p1 = -1, p2 = -1;
        for (int a : arr1) {
            int lb = lower_bound(arr2, a);
            if (lb > 0 && a - arr2[lb - 1] < diff) {
                diff = a - arr2[lb - 1];
                p1 = a;
                p2 = arr2[lb - 1];
            }
            if (lb >= 0 && arr2[lb] - a < diff) {
                diff = arr2[lb] - a;
                p1 = a;
                p2 = arr2[lb];
            }
        }
        System.out.println("Pair is: " + p1 + " and " + p2);
    }

    private static int lower_bound(int arr[], int k) {
        int res = -1;
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                s = mid + 1;
            } else {
                res = mid;
                e = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr1[] = {-1, 5, 10, 20, 3};
        int arr2[] = {26, 134, 135, 15, 17};
        minPair(arr1, arr2);
    }
}
