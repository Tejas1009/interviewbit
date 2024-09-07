package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 207. Course Schedule
 * Medium
 * Topics
 * Companies
 * Hint
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] t : prerequisites) {
            adj.get(t[1]).add(t[0]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean isCyclic = isCycleDfs(adj, i, visited, recStack);
            if (isCyclic) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCycleDfs(List<List<Integer>> adj, int currNode, boolean[] visited, boolean[] recStack) {
        if (recStack[currNode]) return true;
        if (visited[currNode]) return false;
        visited[currNode] = true;
        recStack[currNode] = true;
        List<Integer> neighbours = adj.get(currNode);
        for (int i : neighbours) {
            boolean result = isCycleDfs(adj, i, visited, recStack);
            if (result) {
                return true;
            }
        }
        recStack[currNode] = false;
        return false;
    }
}
