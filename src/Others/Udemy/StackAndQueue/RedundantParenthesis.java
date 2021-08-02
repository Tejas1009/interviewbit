package Others.Udemy.StackAndQueue;
/*
Redundant Parenthesis
Given a string of balanced expression, find if it contains a
redundant parenthesis or not. A set of parenthesis are redundant
if same sub-expression is surrounded by unnecessary or multiple
brackets. Print true if redundant else false.
 */

import java.util.Stack;

public class RedundantParenthesis {
    public static boolean checkRedundant(String str) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            char curr_ch = str.charAt(i);
            i++;
            if (curr_ch != ')') {
                stack.push(curr_ch);
            } else {
                boolean operatorFound = false;
                char ch = stack.pop();
                while (!stack.isEmpty() && ch != '(') {
                    if (ch == '*' || ch == '+') {
                        operatorFound = true;
                    }
                    if (stack.isEmpty()) return true;
                    ch = stack.pop();
                }
                if (!operatorFound) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkRedundant("((a+b)+c)"));
        System.out.println(checkRedundant("((a+(b)+c)"));
        System.out.println(checkRedundant("((a+b+c))"));
    }
}
