package DynamicProgramming;

public class LongestIncreasingSubsequence {
    //https://www.youtube.com/watch?v=mouCn3CFpgg

    public int lis(final int[] arr) {
        int res = 1;
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) dp[i] = 1;//As all elements are LIS of itself
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < j; i++) {// we will run a loo till <j and find out if element at arr[j] is < arr[i] && list[j] <= lis[i]
                //i.e there is some other way from which we got LIS
                if (arr[i] < arr[j] && dp[j] <= dp[i]) {
                    dp[j] = dp[j] + 1;
                    if (res < dp[j]) res = dp[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        l.lis(arr);
    }
}
