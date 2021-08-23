package Others.Udemy.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a string of lower alphabet characters, count total substring of this string which are anagram to each other.

Examples:

Input  : str = “xyyx”
Output : 4
Total substrings of this string which
are anagram to each other are 4 which
can be enumerated as,
{“x”, “x”}, {"y", "y"}, {“xy”, “yx”},
{“xyy”, “yyx”}
 */
public class AnagramPairCount {
    /*
    Algorithm:
    Get all substring for given string in sorted order of characters.
    Put them in a map along with there frequencies.
    No. of Anagrams will for string with frequency > 1 will be NC2 i.e (n*(n-1))/2
     */
    public static int countAnagram(String str) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                char arr[] = str.substring(i, j + 1).toCharArray();
                Arrays.sort(arr);
                String s = String.valueOf(arr);
                map.putIfAbsent(s, 0);
                map.put(s, map.get(s) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                int count = entry.getValue();
                res += (count * (count - 1)) / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAnagram("abba"));
        System.out.println("---------------");
        System.out.println(countAnagram("abbab"));
    }
}
