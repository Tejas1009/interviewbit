package DynamicProgramming;
/*
Problem Description

        Given two strings A and B. Find the longest common sequence ( A sequence which does not need to be contiguous), which is common in both the strings.

        You need to return the length of such longest common subsequence.



        Problem Constraints
        1 <= |A|, |B| <= 1005



        Input Format
        First argument is an string A.

        Second argument is an string B.



        Output Format
        Return the length of such longest common subsequence between string A and string B.



        Example Input
        Input 1:

        A = "abbcdgf"
        B = "bbadcgf"


        Example Output
        Output 1:

        5
*/

public class LongestCommonSubsequence {

    public int solve(String a, String b) {
        if (a.length() <= 0 || b.length() <= 0) return 0;
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        System.out.println(l.solve("abbcdgf", "bbadcgf"));
    }
}