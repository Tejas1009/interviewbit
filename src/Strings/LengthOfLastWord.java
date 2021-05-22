package Strings;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

        If the last word does not exist, return 0.

        Note: A word is defined as a character sequence consists of non-space characters only.

        Example:

        Given s = "Hello World",

        return 5 as length("World") = 5.

        Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
*/

public class LengthOfLastWord {
    public int lengthOfLastWord(final String str) {
        int len = 0;
        if (str.length() <= 0) {
            return 0;
        }
        boolean reset = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                reset = true;
                continue;
            }
            if (reset) {
                len = 0;
                reset = false;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("Hello World  "));
    }
}
