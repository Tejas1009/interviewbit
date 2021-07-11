package Others.Udemy.SlidingWindow;
/*
Given a string write a function to find largest substring with unique characters(no duplicates)

Sample Input:
    aabcd
Sample Output:
    abc
 */

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueSubString {

    public static String uniqueSubstring(String str) {
        int start_idx = 0, max_len = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char curr_ch = str.charAt(i);
            if (map.containsKey(curr_ch)) {
                j = Math.max(map.get(curr_ch) + 1, j);
            }
            map.put(curr_ch, i);
            if (max_len < (i - j)) {
                max_len = (i - j);
                start_idx = j;
            }
        }
        return str.substring(start_idx, start_idx + max_len + 1);
    }

    public static void main(String[] args) {
        System.out.println(uniqueSubstring("aabcd"));
        System.out.println(uniqueSubstring("prateekbhaiya"));
    }
}