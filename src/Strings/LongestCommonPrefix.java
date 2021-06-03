package Strings;
/*Longest Common Prefix
        Asked in:
        Google
        Given the array of strings A,
        you need to find the longest string S which is the prefix of ALL the strings in the array.

        Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
        and S2.

        For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

        Input Format

        The only argument given is an array of strings A.
        Output Format

        Return longest common prefix of all strings in A.
        For Example

        Input 1:
        A = ["abcdefgh", "aefghijk", "abcefgh"]
        Output 1:
        "a"
        Explanation 1:
        Longest common prefix of all the strings is "a".

        Input 2:
        A = ["abab", "ab", "abcd"];
        Output 2:
        "ab"
        Explanation 2:
        Longest common prefix of all the strings is "ab".*/

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    private String getPrefix(String s1, String s2) {
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (i <= s1.length() - 1 && i <= s2.length() - 1 && s1.charAt(i) == s2.charAt(i)) {
            prefix = prefix.append(s1.charAt(i));
            i++;
        }
        return prefix.toString();
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        if (A.size() == 1) {
            return A.get(0);
        }
        String prefix = getPrefix(A.get(0), A.get(1));
        for (int i = 2; i < A.size(); i++) {
            prefix = getPrefix(A.get(i), prefix);
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("abab"));
        System.out.println(l.longestCommonPrefix(arr));
    }
}
