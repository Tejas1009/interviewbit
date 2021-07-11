package Others.Udemy.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the smallest window (substring) which contains all distinct characters of the given input string.
Sample Inputs:
    aabcbcdbcaaad
    aaaa
Sample Output:
    dbca
    a
 */
public class SmallestDistinctWindow {

    public static String smallestWindow(String str) {
        int start = 0;
        int start_idx = 0;
        int window_length = 0;
        int max_so_far = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //aabcbcdbcaaad
        for (int i = 0; i < str.length(); i++) {
            char curr_ch = str.charAt(i);
            if (map.containsKey(curr_ch)) {
                window_length = i - start;
                if (window_length > max_so_far) {
                    max_so_far = window_length;
                    start_idx = start;
                }
                if (map.get(curr_ch) >= start)
                    start = map.get(curr_ch) + 1;
            } else if (i == str.length() - 1) {
                window_length = i - start + 1;
                if (window_length > max_so_far) {
                    max_so_far = window_length;
                    start_idx = start;
                }
            }
            map.put(curr_ch, i);
        }

        return str.substring(start_idx, start_idx + max_so_far);
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("aaaa"));
        System.out.println(smallestWindow("aabcbcdbcaaad"));
        System.out.println(smallestWindow("aabcd"));
    }
}
