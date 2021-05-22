package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    private String getPrefix(String s1, String s2) {
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (i <= s1.length() - 1 && i <= s2.length() - 1 && s1.charAt(i) == s2.charAt(i)) {
            prefix = prefix.append(s1.charAt(i));
            i++;
        }
        return prefix.toString();
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        if(A.size() == 1){
            return A.get(0);
        }
        String prefix = getPrefix(A.get(0), A.get(1));
        for (int i = 2; i < A.size(); i++) {
            prefix = getPrefix(A.get(i), prefix);
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("abab"));
        System.out.println(l.longestCommonPrefix(arr));
    }
}
