package Others.Udemy.Array;

/*
Minimum Difference
Implement a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array) whose absolute difference is closest
 to zero, and returns a pair containing these two numbers, with the first number from array. Only one such pair will exist for the test.

 IP: [23, 5, 10, 17, 30]
     [26, 134, 135, 14, 19]

 OP: [17, 19]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDifference {
    /*
        1)  sort both arrays
        [5, 10, 17, 23, 30]
        [14, 19, 26, 134, 135]
        2)  use two pointer technique and find the closest sum
        i pointer start from 0th element in first array
        j pointer start from 0th element in second array
        --> store the difference in a variable
        --> increment i or j pointer based on which will give me the least difference
        if(first[i] <= second[i]) then increment i as there are more chances of getting closest value to 0
        else increment j pointer
     */

    public static ArrayList<ArrayList<Integer>> minDifference(int a[], int b[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int minimumSum = Integer.MAX_VALUE, ai = -1, bj = -1;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int x = Math.abs(a[i] - b[j]);
            if (x < minimumSum) {
                minimumSum = x;
                ai = a[i];
                bj = b[j];
            }
            if (a[i] <= b[j]) {
                i++;
            } else {
                j++;
            }
        }
        res.add(new ArrayList<>(Arrays.asList(ai, bj)));
        return res;
    }

    public static void main(String[] args) {
        int a[] = {23, 5, 10, 17, 30};
        int b[] = {26, 134, 135, 14, 19};
        minDifference(a, b).forEach(System.out::print);
        System.out.println();
        int a1[] = {1, 3, 15, 11, 2};
        int b1[] = {23, 127, 235, 19, 8};
        minDifference(a1, b1).forEach(System.out::print);
        System.out.println();
        int a2[] = {10, 5, 40};
        int b2[] = {50, 90, 80};
        minDifference(a2, b2).forEach(System.out::print);
        System.out.println();
    }
}