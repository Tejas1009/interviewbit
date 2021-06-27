package Others.ArraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementGeneral {
    public List<Integer> morethanNdK(int a[], int n, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
        int x = n / k;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > x) {
                res.add(entry.getKey());
            }
        }
        return res;
    }


    public static void main(String[] args) {
        MajorityElementGeneral m = new MajorityElementGeneral();
        int a[] = {1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1};
        int a1[] = {4, 5, 6, 7, 8, 4, 4};
        //m.morethanNdK(a, 12, 4).forEach(System.out::println);
        m.morethanNdK(a1, a1.length, 3).forEach(System.out::println);
    }
}
