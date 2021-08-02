package Others;

public class CountOccurancesOfCharacters {
    public static void countOccurances(String input_str) {
        char curr_char = input_str.charAt(0);
        int cnt = 1;
        for (int i = 1; i < input_str.length(); i++) {
            if (curr_char == input_str.charAt(i)) {
                cnt++;
            } else {
                System.out.print(String.valueOf(curr_char) + cnt);
                curr_char = input_str.charAt(i);
                cnt = 1;
            }
        }
        System.out.print(String.valueOf(curr_char) + cnt);
        System.out.println();
    }

    public static void main(String[] args) {
        countOccurances("aaabbccdaa");
    }
}
