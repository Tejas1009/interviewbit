package Strings;

/*Convert to Palindrome
        Asked in:
        Amazon
        Problem Description

        Given a string A consisting only of lowercase characters, we need to check whether it is possible to make this string a palindrome after removing
        exactly one character from this.

        If it is possible then return 1 else return 0.



        Problem Constraints
        3 <= |A| <= 105

        A[i] is always a lowercase character.



        Input Format
        First and only argument is an string A.



        Output Format
        Return 1 if it is possible to convert A to palindrome by removing exactly one character else return 0.



        Example Input
        Input 1:

        A = "abcba"
        Input 2:

        A = "abecbea"


        Example Output
        Output 1:

        1
        Output 2:

        0*/
public class ConvertToPalindrome {
    public int solve(String str) {
        int res = 0, len = str.length() % 2 == 0 ? str.length() / 2 : str.length() / 2 + 1;
        if (len <= 1) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            int j = str.length() - 1 - i;
            if (i != j && str.charAt(i) != str.charAt(j)) {
                boolean isStr1Palindrome = this.checkIfPalindrome(str.substring(i + 1, j + 1));
                boolean isStr2Palindrome = this.checkIfPalindrome(str.substring(i, j));
                if (isStr1Palindrome || isStr2Palindrome) {
                    res = 1;
                }
                break;
            }
            if (i == j) {
                res = 1;
            }
        }
        return res;
    }

    private boolean checkIfPalindrome(String s1) {
        boolean p = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)) {
                p = false;
                break;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        ConvertToPalindrome c = new ConvertToPalindrome();
        System.out.println(c.solve("phmjjmap"));
    }
}
