package Strings;

/*Longest Palindromic Substring
        Asked in:
        Amazon
        Microsoft
        Groupon
        Given a string S, find the longest palindromic substring in S.

        Substring of string S:

        S[i...j] where 0 <= i <= j < len(S)

        Palindrome string:

        A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

        Incase of conflict, return the substring which occurs first ( with the least starting index ).

        Example :

        Input : "aaaabaaa"
        Output : "aaabaaa"*/
public class LongestPalindromic {
    public String calculate(String str) {
        if (str.length() <= 0) {
            return "";
        }
        int maxLength = 0, low = 0, high = 0, start_idx = 0;
        for (int i = 1; i < str.length(); i++) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start_idx = low;
                }
                low--;
                high++;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start_idx = low;
                }
                low--;
                high++;
            }
        }
        return maxLength == 0 ? String.valueOf(str.charAt(0)) : str.substring(start_idx, start_idx + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromic lp = new LongestPalindromic();
        System.out.println(lp.calculate("abecbea"));
    }
}
