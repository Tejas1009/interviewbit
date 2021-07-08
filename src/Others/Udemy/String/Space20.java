package Others.Udemy.String;

/*
Given a string, write a function to replace all spaces in a
string with %20. It is given that the string has sufficient space
at the end to hold the additional characters.
Sample input: a b
Sample output: a%20b
 */
public class Space20 {

    public static String space20(String str) {
        int totalSpaces = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') totalSpaces++;
        }
        char res[] = new char[str.length() + (totalSpaces * 2)];
        int i = str.length() - 1, j = res.length - 1;
        for (; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                res[j] = '0';
                res[j - 1] = '2';
                res[j - 2] = '%';
                j = j - 3;
            } else {
                res[j] = str.charAt(i);
                j--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(space20("hello world,  how are you?"));
        System.out.println(space20("a b"));
    }
}
