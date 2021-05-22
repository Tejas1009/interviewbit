package Strings;

public class StrStr {
    public int strStr(final String A, final String B) {
        if (A.length() <= 0 || B.length() <= 0) {
            return 0;
        }
        int res = -1, j = 0, lastIdx = 0;
        for (int i = 0; i < A.length(); i++) {
            lastIdx = i;
            while (j < B.length() && i < A.length() && B.charAt(j) == A.charAt(i)) {
                j++;
                i++;
            }
            if (j == B.length()) {
                res = lastIdx;
                break;
            }
            j = 0;
            i = lastIdx;
        }
        return res;
    }

    public static void main(String[] args) {
        StrStr s = new StrStr();
        System.out.println(s.strStr("bbbbbbbbab", "bab"));
    }
}
