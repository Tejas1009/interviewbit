package Others.Udemy.Recusrion;

/*
Generating Brackets:
Write a function to generate all possible n pairs of
balanced parentheses '(' and ')'.

Input: 2
Output:
    ()()
    (())
 */
public class GenerateBrackets {

    private static void recur(String output, int open, int close, int i, int n) {
        if (i == 2 * n) {
            System.out.println(output);
            return;
        }
        if (open < n) {
            recur(output + "(", open + 1, close, i + 1, n);
        }
        if (close < open) {
            recur(output + ")", open, close + 1, i + 1, n);
        }
    }

    public static void generateBracket(int n) {
        recur("", 0, 0, 0, n);
    }

    public static void main(String[] args) {
        generateBracket(2);
        System.out.println("-----------------------");
        generateBracket(3);
    }
}