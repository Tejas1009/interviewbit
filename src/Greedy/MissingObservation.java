package Greedy;

import java.util.Arrays;

/**
 * 2028. Find Missing Observations
 * Medium
 * Topics
 * Companies
 * Hint
 * You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.
 * <p>
 * You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.
 * <p>
 * Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.
 * <p>
 * The average value of a set of k numbers is the sum of the numbers divided by k.
 * <p>
 * Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: rolls = [3,2,4,3], mean = 4, n = 2
 * Output: [6,6]
 * Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
 * Example 2:
 * <p>
 * Input: rolls = [1,5,6], mean = 3, n = 4
 * Output: [2,3,2,2]
 * Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.
 * Example 3:
 * <p>
 * Input: rolls = [1,2,3,4], mean = 6, n = 4
 * Output: []
 * Explanation: It is impossible for the mean to be 6 no matter what the 4 missing rolls are.
 */
public class MissingObservation {
    public static void main(String[] args) {
        int[] rolls = {1, 5, 6};
        int mean = 3, n = 4;
        int[] result = missingRolls(rolls, mean, n);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int mTotal = Arrays.stream(rolls).sum();
        int nTotal = ((m + n) * mean) - mTotal;
        if (nTotal < n || nTotal > (n * 6)) {
            return new int[0];
        }
        int[] result = new int[n];
        int i = 0;
        while (nTotal > 0) {
            int dice = Math.min(6, nTotal - n + 1);
            result[i++] = dice;
            n--;
            nTotal -= dice;
        }
        return result;
    }
}
