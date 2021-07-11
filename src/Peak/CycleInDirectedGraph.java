package Peak;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    static int WHITE = 0, GRAY = 1, BLACK = 2;

    private boolean isCyclic(int e, ArrayList<ArrayList<Integer>> adj, int[] color) {
        if (color[e] == GRAY) return true;
        color[e] = GRAY;
        for (int i = 0; i < adj.get(e).size(); i++) {
            if (isCyclic(adj.get(e).get(i), adj, color)) return true;
        }
        color[e] = BLACK;
        return false;
    }

    public boolean solution(int a[], int b[]) {
        int n = a.length;
        int edges[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            edges[i][0] = a[i];
            edges[i][1] = b[i];
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            color[i] = WHITE;
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == WHITE && isCyclic(i, adj, color)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CycleInDirectedGraph c = new CycleInDirectedGraph();
        /*int a[] = {1, 3, 2, 4};
        int b[] = {4, 1, 3, 2};
        System.out.println(c.solution(a, b));
        int a1[] = {1, 2, 1};
        int b1[] = {2, 3, 3};
        System.out.println(c.solution(a1, b1));*/
        int a2[] = {1, 2, 3, 4};
        int b2[] = {2, 1, 4, 3};
        System.out.println(c.solution(a2, b2));
    }
}