package Strings;

import java.util.Arrays;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/?envType=problem-list-v2&envId=oizxjoit
/*
424. Longest Repeating Character Replacement
Medium
Topics
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        if (s.length() <= 1) return 1;
        int[] chars = new int[26];
        Arrays.fill(chars, 0);
        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            chars[s.charAt(right) - 'A']++;
            int windowLength = right - left + 1;
            int mostFrequentElementCount = Arrays.stream(chars).max().getAsInt();
            int capacityToReplace = windowLength - mostFrequentElementCount;

            if (capacityToReplace > k) {
                chars[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
