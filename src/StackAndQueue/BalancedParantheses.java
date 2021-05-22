package StackAndQueue;

import java.util.Stack;

/*Problem Description

        Given a string A consisting only of '(' and ')'.

        You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.



        Problem Constraints
        1 <= |A| <= 105



        Input Format
        First argument is an string A.



        Output Format
        Return 1 if parantheses in string are balanced else return 0.*/
public class BalancedParantheses {
    public int solve(String A) {
        if (A.length() > 0 && A.charAt(0) == ')')
            return 0;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                s.push(A.charAt(i));
            } else {
                if (A.charAt(i) == ')' && !s.empty()) {
                    s.pop();
                    continue;
                }
                return 0;
            }
        }
        return s.empty() ? 1 : 0;
    }

    public static void main(String[] args) {
        BalancedParantheses b = new BalancedParantheses();
        System.out.println(b.solve("(((())()))))"));
    }
}
