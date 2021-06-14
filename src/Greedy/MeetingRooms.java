package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingRooms {

    public int solve(List<List<Integer>> arr) {
        if (arr.size() <= 0) return 0;
        int res = 1;
        List<Integer> start = arr.stream().map(x -> x.get(0)).collect(Collectors.toList());
        List<Integer> end = arr.stream().map(x -> x.get(1)).collect(Collectors.toList());
        Collections.sort(start);
        Collections.sort(end);
        int j = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (start.get(i + 1) < end.get(j)) {
                res++;
                continue;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        MeetingRooms m = new MeetingRooms();
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 18));
        arr.add(Arrays.asList(18, 23));
        arr.add(Arrays.asList(15, 29));
        arr.add(Arrays.asList(4, 15));
        arr.add(Arrays.asList(2, 11));
        arr.add(Arrays.asList(5, 13));
        System.out.println(m.solve(arr));
    }
}