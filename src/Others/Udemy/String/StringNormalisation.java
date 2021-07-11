package Others.Udemy.String;

/*
You are given a sentence with words separated by spaces.
Your task is to:
Write a function that returns a copy of this sentence where all the words:
    start with a capital letter
    the rest of the letters are lower case
    Note:
    Your function should not modify the sentence given as argument.
    Sample Input:
        This is so MUCH FUN!
    Sample Output:
        This Is So Much Fun!
 */
public class StringNormalisation {

    public static String normalize(String str) {
        StringBuilder res = new StringBuilder();
        res = res.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            char curr_ch = str.charAt(i);
            if (Character.isAlphabetic(curr_ch) && str.charAt(i - 1) == ' ') {
                res = res.append(Character.toUpperCase(str.charAt(i)));
            } else {
                res = res.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(normalize("This is so MUCH FUN!"));
    }
}