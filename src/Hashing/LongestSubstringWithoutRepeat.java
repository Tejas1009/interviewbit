package Hashing;

import java.util.HashMap;

/*Given a string,
        find the length of the longest substring without repeating characters.

        Example:

        The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

        For "bbbbb" the longest substring is "b", with the length of 1.*/
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String arr) {
        int max_len = 0, start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (end = 0; end < arr.length(); end++) {
            if (map.containsKey(arr.charAt(end))) {
                start = map.get(arr.charAt(end)) + 1;//Math.max(start, map.get(arr.charAt(end)) + 1);
            }
            map.put(arr.charAt(end), end);
            max_len = Math.max(max_len, end - start + 1);
        }
        return max_len;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat l = new LongestSubstringWithoutRepeat();
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
    }
}
