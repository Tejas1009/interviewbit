package TwoPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=oizxjoit
 * <p>
 * 76. Minimum Window Substring
 * Hard
 * Topics
 * Companies
 * Hint
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        int startIdx = 0, endIdx = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        int need = target.size(), have = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            char currCharacter = s.charAt(end);
            if (target.containsKey(currCharacter)) {
                window.put(currCharacter, window.getOrDefault(currCharacter, 0) + 1);
                if (Objects.equals(window.get(currCharacter), target.get(currCharacter))) {
                    have++;
                }
            }
            while (have == need) {
                if (((end - start + 1) < minLen)) {
                    startIdx = start;
                    endIdx = end;
                    minLen = end - start + 1;
                }
                char windowStartChar = s.charAt(start);
                if (target.containsKey(windowStartChar)) {
                    window.put(windowStartChar, window.get(windowStartChar) - 1);
                    if (window.get(windowStartChar) < target.get(windowStartChar)) {
                        have--;
                    }
                }
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, endIdx + 1);
    }
}
