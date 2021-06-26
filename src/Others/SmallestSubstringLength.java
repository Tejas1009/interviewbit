package Others;

import java.util.*;

public class SmallestSubstringLength {

    public static int solution(String str) {
        // write your code in Java SE 8
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subStr = str.substring(i, j);
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
        }
        List<String> uniqueString = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueString.add(entry.getKey());
            }
        }
        int res = Integer.MAX_VALUE;
        for (String s : uniqueString) {
            res = Math.min(s.length(), res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbbabaaa"));
    }
}
