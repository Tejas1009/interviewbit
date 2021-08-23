package Others.Udemy.Hashing;

import java.util.*;

/*
Given a string without spaces and list of words. Write a function that finds minimum bars
to be added the string, so that all resulting words in are found in the list.

Sample Input:
String s = "thequickbrownfox"
words words = ["the", "quickbrown", "quick", "brown", "fox"]
Output:
2
 */
public class QuickBrownFox {

    private static int recur(String str, Set<String> set, int idx, String asf) {
        if (idx >= str.length()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        String curr_str = "";
        for (int i = idx; i < str.length(); i++) {
            curr_str = curr_str + str.charAt(i);
            asf = asf + str.charAt(i);
            if (set.contains(curr_str)) {
                int newRes = recur(str, set, i + 1, asf);
                if (newRes >= 0) {
                    res = Math.min(res, 1 + newRes);
                }
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public static int getCount(String str, List<String> words) {
        int res = 0;
        Set<String> set = new HashSet<>();
        for (String w : words) {
            set.add(w);
        }
        res = recur(str, set, 0, "");
        return res - 1;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("the", "quickbrown", "quick", "brown", "fox"));
        System.out.println(getCount("thequickbrownfox", words));
    }
}
