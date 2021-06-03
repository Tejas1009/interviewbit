package Strings;

import java.util.HashMap;

/*Given a string A.

        Return the string A after reversing the string word by word.

        NOTE:

        A sequence of non-space characters constitutes a word.

        Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

        If there are multiple spaces between words, reduce them to a single space in the reversed string.



        Input Format

        The only argument given is string A.
        Output Format

        Return the string A after reversing the string word by word.
        For Example

        Input 1:
        A = "the sky is blue"
        Output 1:
        "blue is sky the"

        Input 2:
        A = "this is ib"
        Output 2:
        "ib is this"*/
public class ReverseTheString {
    public String solve(String str) {
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() <= 0) {
                continue;
            }
            sb = sb.length() > 0 ? sb.append(" ").append(arr[i]) : sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseTheString rts = new ReverseTheString();
        System.out.println(rts.solve("  the sky is blue   "));
    }
}