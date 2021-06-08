package Graph;

import java.util.ArrayList;

public class PathInDirectedGraph {
    ArrayList<ArrayList<Integer>> adj;
    boolean visited[];

    private boolean doesPathExists(int curr, ArrayList<Integer> edges, int target) {
        if (target == curr) return true;
        visited[curr] = true;
        for (Integer i : edges) {
            if (!visited[i] && doesPathExists(i, adj.get(i), target)) return true;
        }
        return false;
    }

    public int solve(int a, int[][] edges) {
        adj = new ArrayList<>();
        visited = new boolean[a + 1];
        for (int i = 0; i <= a; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        boolean pathExists = doesPathExists(1, adj.get(1), a);
        return pathExists ? 1 : 0;
    }

    public static void main(String[] args) {
        PathInDirectedGraph p = new PathInDirectedGraph();
        int edges[][] = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        System.out.println(p.solve(5, edges));
    }
}