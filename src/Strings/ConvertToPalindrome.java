package Strings;

public class ConvertToPalindrome {
    public int solve(String str) {
        int res = 0, len = str.length() % 2 == 0 ? str.length() / 2 : str.length() / 2 + 1;
        if (len <= 1) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            int j = str.length() - 1 - i;
            if (i != j && str.charAt(i) != str.charAt(j)) {
                boolean isStr1Palindrome = this.checkIfPalindrome(str.substring(i + 1, j + 1));
                boolean isStr2Palindrome = this.checkIfPalindrome(str.substring(i, j));
                if (isStr1Palindrome || isStr2Palindrome) {
                    res = 1;
                }
                break;
            }
            if (i == j) {
                res = 1;
            }
        }
        return res;
    }

    private boolean checkIfPalindrome(String s1) {
        boolean p = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)) {
                p = false;
                break;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        ConvertToPalindrome c = new ConvertToPalindrome();
        System.out.println(c.solve("phmjjmap"));
    }
}
