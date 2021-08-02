package Others.Udemy.StackAndQueue;

import java.util.Stack;

public class BalancedParanthesis {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            char curr_ch = str.charAt(i);
            i++;
            if (curr_ch == '(' || curr_ch == '[') {
                stack.push(curr_ch);
            } else if (curr_ch == ')') {
                if (stack.isEmpty()) return false;
                char ch = stack.pop();
                if (ch == '(') continue;
                return false;
            } else if (curr_ch == ']') {
                if (stack.isEmpty()) return false;
                char ch = stack.pop();
                if (ch == '[') continue;
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("((a+b)*x-d)"));
        System.out.println(isBalanced("((a+b]+c)*(d-e)"));
    }
}