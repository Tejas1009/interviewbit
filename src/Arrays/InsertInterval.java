package Arrays;

import java.util.*;

/**
 * 57. Insert Interval
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(insert2(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] mergedIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            mergedIntervals[i][0] = intervals[i][0];
            mergedIntervals[i][1] = intervals[i][1];
        }
        mergedIntervals[intervals.length][0] = newInterval[0];
        mergedIntervals[intervals.length][1] = newInterval[1];
        Arrays.sort(mergedIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int temp[] = mergedIntervals[0];
        for (int i = 1; i < mergedIntervals.length; i++) {
            if (temp[1] >= mergedIntervals[i][0]) {
                temp[0] = Math.min(temp[0], mergedIntervals[i][0]);
                temp[1] = Math.max(temp[1], mergedIntervals[i][1]);
            } else {
                result.add(temp);
                temp = mergedIntervals[i];
            }
        }
        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean occuringFirst = false;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(new int[]{newInterval[0], newInterval[1]});
                while (i < intervals.length) {
                    result.add(new int[]{intervals[i][0], intervals[i][1]});
                    i++;
                }
                occuringFirst = true;
                break;
            } else if (newInterval[0] > intervals[i][1]) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        if (!occuringFirst) {
            result.add(newInterval);
        }
        int res[][] = new int[result.size()][1];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
