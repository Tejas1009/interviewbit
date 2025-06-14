package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/partition-labels/description/

/**
 * 763. Partition Labels
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 * <p>
 * Input: s = "eccbbbbdec"
 * Output: [10]
 */
public class PartitionLabels {
    public static void main(String[] args) {
        partitionLabels("eaaaabaaec").stream().forEach(System.out::println);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int prev = -1, max = map.get(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currLastCharIndx = map.get(ch);
            max = Math.max(max, currLastCharIndx);
            if (i == max) {
                result.add(max - prev);
                prev = i;
            }
        }
        return result;
    }
}
