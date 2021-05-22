package Others;

public class LongestCommonPrefix {

    private String getPrefix(String s1, String s2) {
        String str = "";
        int i = 0;
        while (i <= s1.length() - 1 && i <= s2.length() - 1 && s1.charAt(i) == s2.charAt(i)) {
            str += s1.charAt(i);
            i++;
        }
        return str;
    }

    public String get(String arr[], int n) {
        String prefix = this.getPrefix(arr[0], arr[1]);
        for (int i = 1; i < n; i++) {
            prefix = this.getPrefix(prefix, arr[i]);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.get(arr, n));
    }
}
