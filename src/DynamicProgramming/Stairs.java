package DynamicProgramming;
/*
You are climbing a stair case and it takes A steps to reach to the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



        Input Format:

        The first and the only argument contains an integer A, the number of steps.
        Output Format:

        Return an integer, representing the number of ways to reach the top.
        Constrains:

        1 <= A <= 36
        Example :

        Input 1:

        A = 2 Output 1:

        2 Explanation 1:

        [1, 1], [2] Input 2:

        A = 3 Output 2:

        3 Explanation 2:

        [1 1 1], [1 2], [2 1]
*/

public class Stairs {
    int dp[];

    public int recur(int s, int n) {
        if (s == n) {
            return 1;
        }
        if (s > n) {
            return 0;
        }
        if (dp[s] != -1) {
            return dp[s];
        }
        dp[s] = recur(s + 1, n) + recur(s + 2, n);
        return dp[s];
    }

    public int climbStairs(int n) {
        int res = -1;
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = -1;
        res = recur(0, n);
        return res;
    }

    public static void main(String[] args) {
        Stairs s = new Stairs();
        s.climbStairs(10);
    }
}
