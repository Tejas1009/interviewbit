import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval j = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (j.end >= intervals.get(i).start) {
                j.start = Math.min(j.start, intervals.get(i).start);
                j.end = Math.max(j.end, intervals.get(i).end);
            } else {
                result.add(j);
                j = intervals.get(i);
            }
        }
        result.add(j);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(0, new Interval(1, 3));
        merge(intervals);
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
