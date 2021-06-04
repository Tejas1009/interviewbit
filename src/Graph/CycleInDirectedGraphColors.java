package Graph;

import java.util.ArrayList;

public class CycleInDirectedGraphColors {
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

    public int solve(int a, int edges[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(a + 1);
        for (int i = 0; i <= a; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int[] color = new int[a + 1];
        for (int i = 1; i <= a; i++) {
            color[i] = WHITE;
        }
        for (int i = 1; i <= a; i++) {
            if (color[i] == WHITE && isCyclic(i, adj, color)) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CycleInDirectedGraphColors c = new CycleInDirectedGraphColors();
        int m[][] = {{1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}};
        System.out.println(c.solve(5, m));
    }
}
