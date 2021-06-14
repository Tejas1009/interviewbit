package Hashing;

import java.util.*;
import java.util.stream.Collectors;

public class HashingSortByValue {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(200, 3);
        map.put(300, 2);
        map.put(100, 1);
        List<Map.Entry<Integer, Integer>> l = new ArrayList<>(map.entrySet());
        Collections.sort(l, (x, y) -> x.getValue() - y.getValue());
        map.clear();
        for (Map.Entry<Integer, Integer> e : l) {
            map.put(e.getKey(), e.getValue());
        }
        System.out.println(map);
    }
}
