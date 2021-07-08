package Others.Udemy.String;
/*
Given a palindromic string of lowercase English letters , replace exactly one  character with any lowercase English letter so that the resulting string is
not  a palindrome and that it is the lexicographically smallest one possible.
Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string
Input: abccba
Output: aaccba

Input: "a"
Output: ""

Input: "aa"
Output: "ab"

Input: "aba"
Output: "abb"
 */

public class BreakAPalindrome {

    //abccba
    //aaccba
    public static String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";
        int i = 0;
        char chars[] = palindrome.toCharArray();
        while (i < palindrome.length()) {
            if (chars[i] != 'a' && (i != (palindrome.length() / 2))) {
                chars[i] = 'a';
                break;
            }
            i++;
        }
        //all a's
        if (i == palindrome.length()) {
            chars[palindrome.length() - 1] = 'b';
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
        System.out.println(breakPalindrome("a"));
        System.out.println(breakPalindrome("aa"));
        System.out.println(breakPalindrome("aba"));
    }
}