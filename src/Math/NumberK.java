package Math;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class NumberK {
    static int MAX = 10;

    static Vector<Integer> numToVec(int N) {
        Vector<Integer> digit = new Vector<Integer>();

         while (N != 0) {
            digit.add(N % 10);
            N = N / 10;
        }

        // If the original number was 0
        if (digit.size() == 0)
            digit.add(0);
        Collections.reverse(digit);
        return digit;
    }

    static int solve(Vector<Integer> A, int B, int C) {
        Vector<Integer> digit = new Vector<Integer>();
        int d, d2;
        digit = numToVec(C);
        d = A.size();
        if (B > digit.size() || d == 0)
            return 0;

        else if (B < digit.size()) {
            if (A.get(0) == 0 && B != 1)
                return (int) ((d - 1) * Math.pow(d, B - 1));
            else
                return (int) Math.pow(d, B);
        }
        else {
            int[] dp = new int[B + 1];
            int[] lower = new int[MAX + 1];
            for (int i = 0; i < d; i++)
                lower[A.get(i) + 1] = 1;
            for (int i = 1; i <= MAX; i++)
                lower[i] = lower[i - 1] + lower[i];
            boolean flag = true;
            dp[0] = 0;
            for (int i = 1; i <= B; i++) {
                d2 = lower[digit.get(i - 1)];
                dp[i] = dp[i - 1] * d;

                if (i == 1 && A.get(0) == 0 && B != 1)
                    d2 = d2 - 1;

                if (flag)
                    dp[i] += d2;

                flag = (flag & (lower[digit.get(i - 1) + 1] ==
                        lower[digit.get(i - 1)] + 1));
            }
            return dp[B];
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {0, 1, 5};
        // Digits array
        Vector<Integer> A = new Vector<>(Arrays.asList(arr));
        int N = 1;
        int k = 2;

        System.out.println(solve(A, N, k));
    }
}
