package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*Substring Concatenation
        Asked in:
        Facebook
        You are given a string, S, and a list of words, L, that are all of the same length.

        Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

        Example :

        S: "barfoothefoobarman"
        L: ["foo", "bar"]
        You should return the indices: [0,9].
        (order does not matter).*/
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> res = new ArrayList<>();
        if (b.size() <= 0 || a.length() <= 0 || b.get(0) == null || a == null || a.length() < b.get(0).length()) {
            return res;
        }
        int word_cnt = b.size();
        int word_len = b.get(0).length();
        int total_len = word_len * word_cnt;
        if (a.length() < total_len) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        b.forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        for (int i = 0; i < a.length() - total_len + 1; i++) {
            int j = i, cnt = 0;
            HashMap<String, Integer> temp_map = (HashMap<String, Integer>) map.clone();
            while (j < i + total_len) {
                String sub_str = a.substring(j, j + word_len);
                if (temp_map.containsKey(sub_str) && temp_map.get(sub_str) > 0) {
                    temp_map.put(sub_str, temp_map.get(sub_str) - 1);
                    j += word_len;
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == word_cnt) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringConcatenation sc = new SubstringConcatenation();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("foo", "bar"));
        sc.findSubstring("barfoothefoobarman", arr);
    }
}