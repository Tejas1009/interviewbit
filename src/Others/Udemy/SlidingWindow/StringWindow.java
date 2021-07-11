package Others.Udemy.SlidingWindow;

/*
Given two strings, one big string and one small string, find the 'smallest window' in the big string that contains all characters of the small string.
    -Window can have additional characters than required.
    -If small string has duplicates, then those duplicates must be present with the same or higher count in window.
    Input:
        s1 = "hello_world"
        s2 = "lol"
    Output:
        ll0
 */

import java.util.HashMap;
import java.util.Map;

public class StringWindow {

    public static String stringWindow(String str, String pattern) {
        // we will keep 2 hash map. one for storing the frequency of characters in pattern
        // and other for frequency of characters in my current window
        Map<Character, Integer> FP = new HashMap<>();
        Map<Character, Integer> FStr = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            FP.putIfAbsent(ch, 0);
            FP.put(ch, FP.get(ch) + 1);
        }
        /*
            Input:
            s1 = "hello_world"
            s2 = "lol"
            Output:
            "ll0"
         */
        //we will increase our window to right until all characters from pattern are present in my window
        //once done then we will contract window from left removing un-necessary characters
        int cnt = 0;
        int window_length = -1;
        int min_so_far = Integer.MAX_VALUE;
        int start_idx = -1;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            FStr.putIfAbsent(ch, 0);
            FStr.put(ch, FStr.get(ch) + 1);
            if (FP.containsKey(ch) && FStr.get(ch) <= FP.get(ch)) {
                cnt++;
            }
            if (cnt == pattern.length()) {
                //start contracting the window and remove un-wanted characters
                char curr_ch = str.charAt(start);
                while (!FP.containsKey(curr_ch) || FStr.get(curr_ch) > FP.get(curr_ch)) {
                    FStr.put(curr_ch, FStr.get(curr_ch) - 1);
                    start++;
                    curr_ch = str.charAt(start);
                }
                window_length = i - start + 1;
                if (window_length < min_so_far) {
                    min_so_far = window_length;
                    start_idx = start;
                }
            }
        }
        if (start_idx == -1) return "No result found";
        return str.substring(start_idx, start_idx + min_so_far);
    }

    public static void main(String[] args) {
       /* System.out.println(stringWindow("hello_world", "lol"));
        System.out.println(stringWindow("hello_world", "lolo"));
        System.out.println(stringWindow("hello_world", "lolol"));*/
        System.out.println(stringWindow("lol_ll", "ll"));
    }
}