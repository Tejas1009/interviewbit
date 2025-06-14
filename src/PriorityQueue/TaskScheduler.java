package PriorityQueue;

import java.util.*;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 * <p>
 * 621. Task Scheduler
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
 * <p>
 * Return the minimum number of CPU intervals required to complete all tasks.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * <p>
 * Output: 8
 * <p>
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.
 * <p>
 * Example 2:
 * <p>
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * <p>
 * Output: 6
 * <p>
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 * <p>
 * With a cooling interval of 1, you can repeat a task after just one other task.
 * <p>
 * Example 3:
 * <p>
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 * <p>
 * Output: 10
 * <p>
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 * <p>
 * There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tasks.length <= 104
 * tasks[i] is an uppercase English letter.
 * 0 <= n <= 100
 */
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(interval(tasks, n));
    }

    static class Pair {
        int count;
        int availableIdx;

        Pair(int count, int availableIdx) {
            this.count = count;
            this.availableIdx = availableIdx;
        }
    }

    public static int interval(char[] tasks, int n) {
        int time = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry.getValue());
        }
        Queue<Pair> queue = new LinkedList<>();
        while (!priorityQueue.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!priorityQueue.isEmpty()) {
                int cnt = priorityQueue.poll() - 1;
                if (cnt > 0) {
                    queue.add(new Pair(cnt, n + time));
                }
            }
            if (!queue.isEmpty() && queue.peek().availableIdx == time) {
                priorityQueue.add(queue.poll().count);
            }
        }
        return time;
    }
}
