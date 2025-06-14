package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {
    public static void main(String[] args) {
        int intervals[][] = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int result[][] = merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> -(o1[1] - o2[1]));
        List<int[]> result = new ArrayList<>();
        int j = 1;
        int temp[] = intervals[0];
        while (j < intervals.length) {
            if (temp[1] >= intervals[j][0] && temp[0] <= intervals[j][1]) {
                temp[0] = Math.min(temp[0], intervals[j][0]);
                temp[1] = Math.max(temp[1], intervals[j][1]);
            } else {
                result.add(temp);
                temp = intervals[j];
            }
            j++;
        }
        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }
}
