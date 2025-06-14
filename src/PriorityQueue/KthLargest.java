package PriorityQueue;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/1574180045/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 703. Kth Largest Element in a Stream
 * Solved
 * Easy
 * Topics
 * Companies
 * You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.
 * <p>
 * You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.
 * <p>
 * Implement the KthLargest class:
 * <p>
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
 * int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * <p>
 * Output: [null, 4, 5, 5, 8, 8]
 * <p>
 * Explanation:
 * <p>
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4
 * kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5
 * kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["KthLargest", "add", "add", "add", "add"]
 * [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
 * <p>
 * Output: [null, 7, 7, 7, 8]
 * <p>
 * Explanation:
 * <p>
 * KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
 * kthLargest.add(2); // return 7
 * kthLargest.add(10); // return 7
 * kthLargest.add(9); // return 7
 * kthLargest.add(9); // return 8
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest k = new KthLargest(3, nums);
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }

    private PriorityQueue<Integer> priorityQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>();
        for (int n : nums) {
            add(n);
        }
    }

    //we maintain k elements in PQ
    //we add incoming element so PQ is adjusted
    //then remove top element
    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k) priorityQueue.poll();
        return priorityQueue.peek();
    }
}
