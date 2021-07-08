package Others.Udemy.Array;

/*
You are actually very busy person. You have a long list of activities. Your aim is to finish much as activities as possible.
In the given figure, if you go to date with crush, you cannot participate in the coding contest and you can’t watch the movie.
Also if you play DotA, you can’t study for the exam. If you study for the exam you can’t sleep peacefully.
The maximum number of activities that you can do for this schedule is 3.
Either you can
watch movie, play DotA and sleep peacefully (or)
date with crush, play DotA and sleep peacefully

Given the start and finish times of activities, print the maximum number of activities. Input is already store in a vector of pairs.
Each pair contains the start and end of the activity.
Sample Input
(7,9) (0,10) (4,5) (8,9) (4,10) (5,7)
Output:
3
 */

import java.util.Arrays;

public class BusyLife {

    //0,4,4,5,7,8
    //5,7,9,9,10,10
    public static int countActivities(int start[], int end[]) {
        int res = Integer.MIN_VALUE, i = 0, j = 0, activities = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                activities++;
                i++;
            } else {
                i++;
                j++;
                activities = 0;
            }
            res = Math.max(res, activities);
        }
        return res;
    }

    public static void main(String[] args) {
        int start[] = {7, 0, 4, 8, 4, 5};
        int end[] = {9, 10, 5, 9, 10, 7};
        System.out.println(countActivities(start, end));
    }
}
