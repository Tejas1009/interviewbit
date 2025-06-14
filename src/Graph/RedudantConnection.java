package Graph;

/**
 * https://leetcode.com/problems/redundant-connection/description/
 * 684. Redundant Connection
 * Solved
 * Medium
 * Topics
 * Companies
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * Example 2:
 * <p>
 * <p>
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 */
public class RedudantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1, 4}, {3, 4}, {1, 3}, {2, 3}};
        int[] res = findRedundantConnection(edges);
        System.out.print(res[0] + "-" + res[1]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = findParent(edge[0], parent);
            int p2 = findParent(edge[1], parent);
            if (p1 == p2) {
                return new int[]{edge[0], edge[1]};
            }
            union(edge[0], edge[1], parent);
        }
        return null;
    }

    private static void union(int fromP, int toP, int parent[]) {
        int p1 = findParent(fromP, parent);
        int p2 = findParent(toP, parent);
        if (p1 == p2) {
            return;
        }
        parent[p2] = p1;
    }

    private static int findParent(int source, int parent[]) {
        if (parent[source] == source) return source;
        int p = findParent(parent[source], parent);
        parent[source] = p;
        return parent[source];
    }
}
