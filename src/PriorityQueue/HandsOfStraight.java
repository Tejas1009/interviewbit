package PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/hand-of-straights/description/?envType=problem-list-v2&envId=plakya4j
 * 846. Hand of Straights
 * Medium
 * Topics
 * Companies
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
 * <p>
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 * Explanation: Alice's hand can not be rearranged into groups of 4.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 */
public class HandsOfStraight {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : hand) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> map : countMap.entrySet()) {
            priorityQueue.add(map.getKey());
        }
        while (!priorityQueue.isEmpty()) {
            int first = priorityQueue.peek();
            int last = first + groupSize;
            for (int i = first; i < last; i++) {
                if (!countMap.containsKey(i) || countMap.get(i) <= 0) {
                    return false;
                }
                countMap.put(i, countMap.get(i) - 1);
                if (countMap.get(i) <= 0) {
                    if (priorityQueue.peek() != i) {
                        return false;
                    }
                    priorityQueue.poll();
                }
            }
        }
        return true;
    }
}
