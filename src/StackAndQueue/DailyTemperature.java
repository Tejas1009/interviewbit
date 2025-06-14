package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 739. Daily Temperatures
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * <p>
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * <p>
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temperatures);
        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        int n = temperatures.length;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > stack.peek().temp) {
                Pair pair = stack.pop();
                res[pair.index] = i - pair.index;
            }
            stack.push(new Pair(i, temperature));
        }
        return res;
    }

    public static class Pair {
        int temp;
        int index;

        public Pair(int index, int temp) {
            this.index = index;
            this.temp = temp;
        }
    }
}
