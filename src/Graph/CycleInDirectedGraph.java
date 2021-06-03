package Graph;

import java.util.ArrayList;

public class CycleInDirectedGraph {

    private boolean cyclic(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] visited) {
        if (visited[curr]) return true;
        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            if (cyclic(adj, adj.get(curr).get(i), visited)) return true;
        }
        visited[curr] = false;
        return false;
    }

    public int solve(int a, int edges[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(a + 1);
        for (int i = 0; i <= a; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[a + 1];
        for (int i = 1; i <= a; i++) {
            visited[i] = true;
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (cyclic(adj, adj.get(i).get(j), visited)) return 1;
            }
            visited[i] = false;
        }
        return 0;
    }

    public static void main(String[] args) {
        CycleInDirectedGraph c = new CycleInDirectedGraph();
        int m[][] = {{1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}};
        System.out.println(c.solve(5, m));
    }
}