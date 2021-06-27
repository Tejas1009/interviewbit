package Others.ArraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    //ababcbaca defegde hijhklij
    //9,7,8
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int max_idx = 0, prev_idx = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, i);
            map.put(ch, i);
        }
        max_idx = map.get(s.charAt(0));
        ////ababcbaca defegde hijhklij
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < max_idx) {
                continue;
            } else if (map.get(s.charAt(i)) > max_idx) {
                max_idx = map.get(s.charAt(i));
            } else if (i == max_idx) {
                res.add(max_idx - prev_idx);
                prev_idx = max_idx;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        p.partitionLabels("ababcbacadefegdehijhklij").forEach(System.out::print);
        System.out.println();
        p.partitionLabels("eccbbbbdec").forEach(System.out::print);
    }
}
