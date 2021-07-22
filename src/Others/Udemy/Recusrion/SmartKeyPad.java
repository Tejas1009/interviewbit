package Others.Udemy.Recusrion;

public class SmartKeyPad {
    private static String keypad[] = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    private static void recur(String input, String output, int i) {
        if (i == input.length()) {
            System.out.println(output);
            return;
        }
        int current_digit = input.charAt(i) - '0';
        for (char ch : keypad[current_digit].toCharArray()) {
            recur(input, output + ch, i + 1);
        }
    }

    public static void printKeyPadOutput(String input) {
        recur(input, "", 0);
    }

    public static void main(String[] args) {
        printKeyPadOutput("23");
        System.out.println("------------------");
        printKeyPadOutput("32");
    }
}
