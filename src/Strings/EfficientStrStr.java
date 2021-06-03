package Strings;

/*Implement StrStr
        Asked in:
        Facebook
        Amazon
        Qualcomm
        Wipro
        Microsoft

        Implement strStr().

        strstr - locate a substring ( needle ) in a string ( haystack ).
        Try not to use standard library string functions for this question.

        Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

        NOTE: Good clarification questions:
        What should be the return value if the needle is empty?
        What if both haystack and needle are empty?
        For the purpose of this problem, assume that the return value should be -1 in both cases.*/
public class EfficientStrStr {
    public int strStr(final String A, final String B) {
        int res = -1, counter = 0, i = 0;
        for (; i < A.length(); i++) {
            if (counter == B.length()) {
                res = i;
                break;
            } else if (A.charAt(i) == B.charAt(counter)) {
                counter++;
            } else {
                counter = 0;
            }
        }
        return counter < B.length() ? res : i - counter;
    }

    public static void main(String[] args) {
        EfficientStrStr s = new EfficientStrStr();
        System.out.println(s.strStr("needle", "dle"));
    }
}
