package StackAndQueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/?envType=problem-list-v2&envId=oizxjoit
 * <p>
 * 20. Valid Parentheses
 * Easy
 * Topics
 * Companies
 * Hint
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * <p>
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(]"
 * <p>
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: s = "([])"
 * <p>
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("}{"));
    }

    public static boolean isValid(String s) {
        if (s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else if (ch == ')' && stack.pop() != '(') {
                return false;
            } else if (ch == '}' && stack.pop() != '{') {
                return false;
            } else if (ch == ']' && stack.pop() != '[') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
