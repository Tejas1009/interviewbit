package Others.Udemy.String;

/*
Given two non-empty strings, write a function that
determines whether the second string is a subsequence of first one.

Sample input: codingminutes
              cines
Sample output: Yes
 */

public class CheckSubsets {

    //codingminutes
    //cines
    public static void check(String str, String sub) {
        int i = 0, j = 0;
        while (j < sub.length() && i < str.length()) {
            if (str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j > (sub.length() - 1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        check("codingminutes", "cines");
        check("codingminutes", "cinex");
        check("codingminutes", "cgs");
        check("codingminutes", "se");
    }
}