package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Alien Dictionary
 * Difficulty: HardAccuracy: 47.81%Submissions: 129K+Points: 8
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
 * Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 * <p>
 * Examples :
 * <p>
 * Input:  n = 5, k = 4, dict = {"baa","abcd","abca","cab","cad"}
 * Output: 1
 * Explanation: Here order of characters is 'b', 'd', 'a', 'c' Note that words are sorted and in the given language "baa" comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * Input: n = 3, k = 3, dict = {"caa","aaa","aab"}
 * Output: 1
 * Explanation: Here order of characters is 'c', 'a', 'b' Note that words are sorted and in the given language "caa" comes before "aaa", therefore 'c' is before 'a' in output.
 * Similarly we can find other orders.
 * Expected Time Complexity: O(n * |s| + k)
 * Expected Auxillary Space: O(k)
 */
public class AlienDictionary {
    public static void main(String[] args) {
        String[] str = {"caa", "aaa", "aab"};//{"dhhid", "dahi", "cedg", "fg", "gdah", "i", "gbdei", "hbgf", "e", "ddde"};
        System.out.println(findOrder(str, 3, 3));
    }

    public static String findOrder(String[] dict, int n, int k) {
        StringBuilder result = new StringBuilder();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int size = Math.min(s1.length(), s2.length());
            for (int j = 0; j < size; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        List<Integer> order = topoSort(k, adj);
        for (int i : order) {
            result.append((char) (i + ('a')));
        }
        return result.toString();
    }

    private static List<Integer> topoSort(int k, List<List<Integer>> adj) {
        int indegree[] = new int[k];
        for (int i = 0; i < k; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            List<Integer> neigbours = adj.get(currNode);
            result.add(currNode);
            for (Integer neighbour : neigbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }
}
