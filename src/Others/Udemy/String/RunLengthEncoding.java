package Others.Udemy.String;

/*
Write a function to perform basic string compression using the counts of repeated characters, also known as Run Length Encoding.
Let see one example, the input string "aaaabcccccaaa" would become "a4b1c5a3". If the "compressed" string would not become smaller than the original
string, your function should return the input string. You can assume the string has only uppercase and lowercase letters.
 Input: bbbaaaadexxxxxx
 Output: b3a4d1e1x6

 Input: abc
 Output: abc
 */
public class RunLengthEncoding {

    public static String compressString(String str) {
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        char curr_ch = str.charAt(0);
        while (i < str.length()) {
            if (str.charAt(i) == curr_ch) {
                j++;
            } else {
                res = res.append(String.valueOf(curr_ch) + j);
                j = 1;
                curr_ch = str.charAt(i);
            }
            i++;
        }
        res = res.append(String.valueOf(curr_ch) + j);
        if (res.length() >= str.length()) return str;
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("bbbaaaadexxxxxx"));
        System.out.println(compressString("abc"));
    }
}