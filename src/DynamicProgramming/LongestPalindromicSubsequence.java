package DynamicProgramming;

/*
Longest Palindromic Subsequence
        Asked in:
        LinkedIn
        Problem Description

        Given a string A, find the common palindromic sequence ( A sequence which does not need to be contiguous and is a pallindrome), which is common in itself.

        You need to return the length of longest palindromic subsequence in A.

        NOTE:

        Your code will be run on multiple test cases (<=10). Try to come up with an optimised solution.


        Problem Constraints
        1 <= |A| <= 1005



        Input Format
        First and only argument is an string A.



        Output Format
        Return a integer denoting the length of longest palindromic subsequence in A.



        Example Input
        Input 1:

        A = "bebeeed"


        Example Output
        Output 1:

        4


        Example Explanation
        Explanation 1:

        The longest common pallindromic subsequence is "eeee", which has a length of 4
*/

public class LongestPalindromicSubsequence {

    public int solve(String a) {
        if (a.length() <= 1) return a.length();
        int n = a.length();
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = k; j < a.length(); j++, i++) {
                if (a.charAt(i) == a.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
            k++;
            i = -1;
            n = n - 1;
        }
        return dp[0][a.length() - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
        System.out.println(l.solve("bebeeed"));
    }
}
