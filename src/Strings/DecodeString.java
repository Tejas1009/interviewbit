package Strings;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/description/
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                StringBuilder subString = new StringBuilder();
                while (stack.peek() != '[') {
                    subString.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder numericString = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    char cc = stack.pop();
                    numericString.insert(0, cc);
                }
                int count = Integer.parseInt(numericString.toString());
                while (count > 0) {
                    for (char c : subString.toString().toCharArray()) {
                        stack.push(c);
                    }
                    count--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
