package Strings;

/**
 * 5. Longest Palindromic Substring
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s, return the longest
 * palindromic
 * <p>
 * substring
 * in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int maxL = 0, maxR = 0;
        int l, r;
        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int currLen = r - l + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxL = l;
                    maxR = r;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                int currLen = r - l + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxL = l;
                    maxR = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(maxL, maxR + 1);
    }
}
