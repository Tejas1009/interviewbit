public class LongestPalindrome {

    static String longestPalSubstr(String str) {
        int n = str.length() - 1;
        int low, high;
        int start = 0, maxLength = 1;

        for (int i = 1; i <= n; i++) {
            low = i - 1;
            high = i;
            while (low >= 0 && high <= n && str.charAt(low) == str.charAt(high)) {
                if (high - low > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                --low;
                ++high;
            }

            low = i - 1;
            high = i + 1;
            while (low >= 0 && high <= n && str.charAt(low) == str.charAt(high)) {
                if (high - low > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                --low;
                ++high;
            }
        }
        for (int i = start; i < maxLength; i++) {
            System.out.print(str.charAt(i));
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "geeksskeeg";
        longestPalSubstr(str);
    }
}
