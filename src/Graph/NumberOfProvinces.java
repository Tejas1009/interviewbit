package Graph;

/**
 * https://leetcode.com/problems/number-of-provinces/description/
 * <p>
 * 547. Number of Provinces
 * Solved
 * Medium
 * Topics
 * Companies
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 * <p>
 * <p>
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int parent[] = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < cities; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    union(i, j, parent);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private static void union(int from, int to, int parent[]) {
        int fromP = find(from, parent);
        int toP = find(to, parent);
        if (toP == fromP) {
            return;
        }
        parent[toP] = fromP;
    }

    private static int find(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }
}
