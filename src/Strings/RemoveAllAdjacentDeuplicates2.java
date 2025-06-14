package Strings;
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * <p>
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * <p>
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */
public class RemoveAllAdjacentDeuplicates2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }

    public static class CharCount {
        int count;
        char c;

        CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    //deeedbbcccbdaa
    public static String removeDuplicates(String s, int k) {
        Stack<CharCount> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                CharCount curr = stack.peek();
                curr.count++;
            } else {
                stack.push(new CharCount(c, 1));
            }
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            CharCount ch = stack.pop();
            for (int i = 0; i < ch.count; i++) {
                result.append(ch.c);
            }
        }
        return result.reverse().toString();
    }
}
