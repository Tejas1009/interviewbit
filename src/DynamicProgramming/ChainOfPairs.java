package DynamicProgramming;
/*
Chain of Pairs
        Asked in:
        Amazon
        Directi
        Problem Description

        Given a N * 2 array A where (A[i][0], A[i][1]) represents the ith pair.

        In every pair, the first number is always smaller than the second number.

        A pair (c, d) can follow another pair (a, b) if b < c , similarly in this way a chain of pairs can be formed.

        Find the length of the longest chain subsequence which can be formed from a given set of pairs.



        Problem Constraints
        1 <= N <= 103

        1 <= A[i][0] < A[i][1] <= 104



        Input Format
        First and only argument is an 2D integer array A of size N * 2 representing the N pairs.



        Output Format
        Return a single integer denoting the length of longest chain subsequence of pairs possible under given constraint.



        Example Input
        Input 1:

        A = [  [5, 24]
        [39, 60]
        [15, 28]
        [27, 40]
        [50, 90]
        ]
        Input 2:


        A = [   [10, 20]
        [1, 2]
        ]
*/

public class ChainOfPairs {

    public int solve(int[][] pairs) {
        int res = 1;
        int dp[] = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) dp[i] = 1;

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) {
                    dp[i] = 1 + dp[j];
                    if (res < dp[i]) res = dp[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[][] = {
                {5, 24},
                {39, 60},
                {15, 28},
                {27, 40},
                {50, 90},
        };
        int b[][] = {
                {10, 20},
                {1, 2}
        };
        int d[][] = {
                {98, 894},
                {397, 942},
                {70, 519},
                {258, 456},
                {286, 449},
                {516, 626},
                {370, 873},
                {214, 224},
                {74, 629},
                {265, 886},
                {708, 815},
                {394, 770},
                {56, 252}
        };
        ChainOfPairs c = new ChainOfPairs();
        System.out.println(c.solve(a));
    }
}