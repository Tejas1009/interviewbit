package Others.Udemy.DynamicProgramming;

/*
Ladder Problem/Stair Case:
Given a ladder of size N, and integer k, write a function to compute number of ways
to climb the ladder if you can take a jump of atmost k at every steps.
 */
public class LadderProblem {

    //O(nk)
    //For every cell we are summing up last k values
    private static int countWaysBottomUp(int n, int k) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if ((i - j) < 0) continue;
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    //O(n^k) with out memoization
    private static int countWaysTopDown(int n, int k, int dp[]) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != 0) return dp[n];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += countWaysTopDown(n - i, k, dp);
            dp[n] = ans;
        }
        return ans;
    }

    public static int calculate(int n, int k) {
        int res = 0;
        int dp[] = new int[n + 1];
        //res = countWaysBottomUp(n, k);
        res = countWaysTopDown(n, k, dp);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate(4, 3));
    }
}