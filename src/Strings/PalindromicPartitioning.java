package Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        List<List<String>> res = partition("aab");
        for (List<String> r : res) {
            for (String s : r) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(String s, int idx, List<String> currPartition, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(currPartition));
            return;
        }
        for (int j = idx; j < s.length(); j++) {
            if (isPalindrome(s, idx, j)) {
                currPartition.add(s.substring(idx, j + 1));
                dfs(s, j + 1, currPartition, res);
                currPartition.remove(currPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
