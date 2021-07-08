package Others.Udemy.String;

import java.util.*;

public class StringKeySort {
    /*
    Sample input:
        3
        92  022
        82  12
        77  13
        2 false numeric
    Sample output:
        82  12
        77  13
        92  022
     */
    public static List<String> sort(ArrayList<String> v, int key, boolean reverse, boolean useNumericSorting) {
        List<String> res = new ArrayList<>();
        //Extract key and store
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < v.size(); i++) {
            String[] s = v.get(i).split(" ");
            String k = s[key - 1];
            map.put(v.get(i), k);
        }
        //sort
        if (useNumericSorting) {
            res = NumericComparator(map);
        } else {
            res = StringComparator(map);
        }

        if (reverse)
            Collections.reverse(res);
        return res;
    }

    private static List<String> NumericComparator(HashMap<String, String> map) {
        List<String> res = new ArrayList<>();
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (x, y) -> {
            return Integer.valueOf(x.getValue()).compareTo(Integer.valueOf(y.getValue()));
        });
        for (Map.Entry<String, String> entry : list) {
            res.add(entry.getKey());
        }
        return res;
    }

    private static List<String> StringComparator(HashMap<String, String> map) {
        List<String> res = new ArrayList<>();
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (x, y) -> {
            return x.getValue().compareTo(y.getValue());
        });
        for (Map.Entry<String, String> entry : list) {
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("92 022", "82 12", "77 13"));
        sort(input, 2, false, true).forEach(System.out::println);
        System.out.println("-----------------");
        sort(input, 2, false, false).forEach(System.out::println);
        System.out.println("-----------------");
        sort(input, 2, true, true).forEach(System.out::println);
        System.out.println("-----------------");
        sort(input, 2, true, false).forEach(System.out::println);
    }
}
