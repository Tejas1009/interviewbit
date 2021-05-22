package StackAndQueue;

public class RainWaterTrapped {
    /*
        Problem Description

        Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



                Problem Constraints
    1 <= |A| <= 100000



        Input Format
        The only argument given is integer array A.



        Output Format
        Return the total water it is able to trap after raining.



                Example Input
        Input 1:

        A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        Input 2:

        A = [1, 2]


        Example Output
        Output 1:

                6
        Output 2:

                0
    */
    public int trap(final int[] arr) {
        if (arr.length <= 2) {
            return 0;
        }
        int res = 0, l_max = arr[0], r_max = arr[arr.length - 1], left = 1, right = arr.length - 2;
        while (left <= right) {
            if (r_max <= l_max) {
                res += Math.max(0, r_max - arr[right]);
                r_max = Math.max(r_max, arr[right]);
                right--;
            } else {
                res += Math.max(0, l_max - arr[left]);
                l_max = Math.max(l_max, arr[left]);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RainWaterTrapped r = new RainWaterTrapped();
        int arr[] = {3, 4, 5};
        System.out.println(r.trap(arr));
    }
}
