package Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-the-number-of-complete-components/
 * <p>
 * 2685. Count the Number of Complete Components
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
 * <p>
 * Return the number of complete connected components of the graph.
 * <p>
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
 * <p>
 * A connected component is said to be complete if there exists an edge between every pair of its vertices.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
 * Output: 3
 * Explanation: From the picture above, one can see that all of the components of this graph are complete.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
 * Output: 1
 * Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 * 0 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * There are no repeated edges.
 */
public class CountCompleteComponents {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(countCompleteComponents(6, edges));
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent);
        }
        //count nodes
        //count edges
        //a complete component has n*(n-1)/2 edges
        Map<Integer, Integer> nodeCount = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int root = findParent(i, parent);
            nodeCount.put(root, nodeCount.getOrDefault(root, 0) + 1);
        }
        for (int[] edge : edges) {
            int root = findParent(edge[0], parent);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }
        int res = 0;
        for (int root : nodeCount.keySet()) {
            int nodes = nodeCount.get(root);
            int edgesInComponent = edgeCount.getOrDefault(root, 0);
            if (edgesInComponent == nodes * (nodes - 1) / 2) {
                res++;
            }
        }
        return res;
    }

    private static void union(int n1, int n2, int[] parent) {
        int p1 = findParent(n1, parent);
        int p2 = findParent(n2, parent);
        if (p1 == p2) {
            return;
        }
        parent[p2] = p1;
    }

    private static int findParent(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node], parent);
        }
        return parent[node];
    }
}
