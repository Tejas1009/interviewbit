package Others.Udemy.Recusrion;

/*
Find all subsets/subsequences of given string
they should be 2^n
because each character has 2 choices either to include or exclude
 */
public class StringSubSets {

    private static void recur(String str, String remaining_str, int i) {
        if (i == str.length()) {
            System.out.println(remaining_str);
            return;
        }
        recur(str, remaining_str + str.charAt(i), i + 1);
        recur(str, remaining_str, i + 1);
    }

    public static void subSets(String str) {
        recur(str, "", 0);
    }

    public static void main(String[] args) {
        subSets("abc");
        System.out.println("----------------------");
        subSets("tejas");
    }
}