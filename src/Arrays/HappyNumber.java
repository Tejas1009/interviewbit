package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/?envType=problem-list-v2&envId=plakya4j
 * 202. Happy Number
 * Solved
 * Easy
 * Topics
 * Companies
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: false
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = getNumber(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private static int getNumber(int n) {
        int newNumber = 0;
        while (n > 0) {
            int temp = n % 10;
            newNumber += temp * temp;
            n = n / 10;
        }
        return newNumber;
    }
}
