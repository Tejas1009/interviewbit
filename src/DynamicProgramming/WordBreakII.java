package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class WordBreakII {

    public static ArrayList<String> wordBreak(String a, ArrayList<String> dictionary) {
        ArrayList<String>[] dp = new ArrayList[a.length() + 1];
        dp[0] = new ArrayList<String>();


        for (int i = 0; i <= a.length(); i++) {
            //System.out.println("At i = " + i);
            if (dp[i] == null)
                continue;
            for (String word : dictionary) {
                //System.out.println("\t Word: " + word);
                int length = word.length();
                int end = i + length;

                if (end > a.length())
                    continue;
                //System.out.println("\t substring: " + a.substring(i, end));
                if (a.substring(i, end).equals(word)) {
                    //System.out.println("\t \t adding to DP");
                    if (dp[end] == null)
                        dp[end] = new ArrayList<String>();
                    dp[end].add(word);
                }
            }
            //System.out.println("\t DP has : ");
            for (int j = 0; j < dp.length; j++) {
                //System.out.println("\t \t" + dp[j]);
            }
        }

        ArrayList<String> result2 = new ArrayList<String>();
        HashSet<String> result = new HashSet<String>();
        if (dp[a.length()] == null)
            return result2;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, a.length(), result, temp);

        for (String s : result)
            result2.add(s);
        Collections.sort(result2);
        return result2;
    }

    public static void dfs(ArrayList<String>[] dp, int end, HashSet<String> result, ArrayList<String> temp) {
        //System.out.println("Temp : " + temp);
        if (end <= 0) {
            String path = temp.get(temp.size() - 1);
            for (int i = temp.size() - 2; i >= 0; i--)
                path += " " + temp.get(i);
            //System.out.println("\t add to DP : " + path);
            result.add(path);
            return;
        }

        for (String str : dp[end]) {
            temp.add(str);
            dfs(dp, end - str.length(), result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordBreakII w = new WordBreakII();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        w.wordBreak("catsanddog", arr);
    }
}
