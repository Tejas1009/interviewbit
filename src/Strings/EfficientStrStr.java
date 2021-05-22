package Strings;

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
        System.out.println(s.strStr("", "ge"));
    }
}
