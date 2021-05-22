package Hashing;

import java.util.HashMap;
import java.util.Map;

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
        Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

        Example :

        S = "ADOBECODEBANC"
        T = "ABC"*/
public class WindowString {
    public String minWindow(String s1, String s2) {
        String res = "";
        int i = -1, j = -1, match_count = 0, desired_count = s2.length();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int k = 0; k < s2.length(); k++) {
            map2.put(s2.charAt(k), map2.getOrDefault(s2.charAt(k), 0) + 1);
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        while (true) {
            boolean f1 = false, f2 = false;
            //add
            while (i < s1.length() - 1 && j < s1.length() && match_count < desired_count) {
                f1 = true;
                i++;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    match_count++;
                }
            }
            //remove
            while (j < i && match_count >= desired_count) {
                f2 = true;
                String pans = s1.substring(j + 1, i + 1);
                if (res.length() == 0 || pans.length() < res.length()) {
                    res = pans;
                }
                j++;
                char ch = s1.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    match_count--;
                }
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        return res;
    }

    public String minWindow2(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : B.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();
        int idx = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int endIdx = -1;

        while (idx < A.length()) {
            if (map.containsKey(A.charAt(idx))) {
                map.put(A.charAt(idx), map.get(A.charAt(idx)) - 1);
                if (map.get(A.charAt(idx)) == 0) {
                    count--;
                }
            }

            while (start < A.length() && count == 0) {
                if (minLen > idx - start + 1) {
                    startIdx = start;
                    endIdx = idx + 1;
                    minLen = idx - start + 1;
                }
                if (map.containsKey(A.charAt(start))) {
                    map.put(A.charAt(start), map.get(A.charAt(start)) + 1);
                    if (map.get(A.charAt(start)) == 1) {
                        count++;
                    }
                }

                start++;
            }

            idx++;
        }

        return minLen == Integer.MAX_VALUE ? "" : A.substring(startIdx, endIdx);
    }

    public static void main(String[] args) {
        WindowString ws = new WindowString();
        System.out.println(ws.minWindow2("ADOBECODEBANC", "ABC"));
        //System.out.println(ws.minWindow("ADOBECODEBANC", "ABC"));
    }
}
