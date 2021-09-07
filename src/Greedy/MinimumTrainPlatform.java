package Greedy;

import java.util.Arrays;

/*
Given the arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays that represent the arrival and departure times of trains that stop.

Input:
arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output:
3
Explanation: There are at-most three trains
at a time (time between 11:00 to 11:20)
Input:
arr[] = {9:00, 9:40}
dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.
2.
 */
public class MinimumTrainPlatform {
    //O(N * log N)
    public static int getMinimumPlatformsNeeded(int arrival[], int dept[]) {
        int res = 0;
        int n = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(dept);
        int platformNeeded = 1, j = 0, i = 1;
        while (i < n && j < n) {
            if (arrival[i] <= dept[j]) {
                platformNeeded++;
                i++;
            } else {
                j++;
                platformNeeded--;
            }
            res = Math.max(res, platformNeeded);
        }
        return res;
    }

    public static void main(String[] args) {
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int dept[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(getMinimumPlatformsNeeded(arrival, dept));
    }
}
