package BackTracking;
/*
Given a string s, partition s such that every string of the partition is a palindrome.

        Return all possible palindrome partitioning of s.

        For example, given s = "aab",
        Return

        [
        ["a","a","b"]
        ["aa","b"],
        ]
        Ordering the results in the answer : Entry i will come before Entry j if :
        len(Entryi[0]) < len(Entryj[0]) OR
        (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
        *
        *
        *
        (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
        In the given example,
        ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")

        Seen this question in a real interview beforeYesNo
*/

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PalindromePartitioning {

    private boolean isPalindrome(String s) {
        boolean res = true;
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                res = false;
                break;
            }
            l++;
            r--;
        }
        return res;
    }

    //asf = answer so far
    //osf = op so far
    private void calculatePalindromicStrings(String s, String asf, ArrayList<ArrayList<String>> res) {
        if (s.length() == 0) {
            ArrayList<String> ans = Stream.of(asf.split(","))
                    .map(String::trim)
                    .collect(Collectors.toCollection(ArrayList::new));
            res.add(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if (isPalindrome(prefix)) {
                String ros = s.substring(i + 1);
                calculatePalindromicStrings(ros, asf + prefix + ",", res);
            }
        }
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        calculatePalindromicStrings(a, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        pp.partition("cccaacbcaabb");
    }
}