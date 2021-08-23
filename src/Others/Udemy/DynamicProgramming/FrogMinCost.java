package Others.Udemy.DynamicProgramming;

/*
Frog Minimum cost:
There are N stones given in the form an array, each element in array represents the height of ith stone. There is a frog who is initially on Stone 1.
Frog will repeat the following action same number of times to reach stone N:
If the frog is currently on Stone i, jump to Stone i+1 or Stone i+2. Here, a cost of |hi-hj| is incurred,
where j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone N.
 */
public class FrogMinCost {

    public static int calculate(int height[]) {
        int n = height.length;
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(height[0] - height[1]);
        for (int i = 2; i < height.length; i++) {
            int op1 = dp[i - 1] + Math.abs(height[i - 1] - height[i]);
            int op2 = dp[i - 2] + Math.abs(height[i - 2] - height[i]);
            dp[i] = Math.min(op1, op2);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int height[] = {10, 30, 40, 20};
        System.out.println(calculate(height));
    }
}
