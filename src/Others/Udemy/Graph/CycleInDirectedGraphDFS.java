package Others.Udemy.Graph;

import java.util.ArrayList;

public class CycleInDirectedGraphDFS {
    private static boolean visited[];

    private static boolean recur(int node, ArrayList<ArrayList<Integer>> adj) {
        if (visited[node]) return true;
        visited[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            boolean isCyclic = recur(adj.get(node).get(i), adj);
            if (isCyclic) return true;
        }
        visited[node] = false;
        return false;
    }

    public static boolean isCyclic(int numVertices, int edges[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numVertices + 1);
        for (int i = 0; i <= numVertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        visited = new boolean[numVertices + 1];
        for (int i = 1; i <= numVertices; i++) {
            if (recur(i, adj)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 5},
                {1, 6},
                {6, 5},
                //{4, 1}
        };
        System.out.println(isCyclic(6, mat));
    }
}
