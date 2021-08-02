package Others.Udemy.Graph;

import java.util.Arrays;

public class CycleInUnDirectedGraph {
    UGraph g;
    private static int parent[];

    private static int findParent(int source) {
        if (parent[source] == -1) {
            return source;
        }
        parent[source] = findParent(parent[source]);
        return parent[source];
    }

    private static void union(int fromP, int toP) {
        parent[toP] = fromP;
    }

    public static boolean isCyclic(int numVertices, int mat[][]) {
        parent = new int[numVertices + 1];
        Arrays.fill(parent, -1);
        for (int pair[] : mat) {
            int fromP = findParent(pair[0]);
            int toP = findParent(pair[1]);
            if (fromP == toP) {
                System.out.println(pair[0] + " - " + pair[1]);
                return true;
            }
            union(fromP, toP);
        }
        return false;
    }

    public static void main(String[] args) {
        int m[][] = {
                {1, 2},
                {2, 3},
                {1, 4},
                {4, 5},
                {1, 3}
        };
        System.out.println(isCyclic(5, m));
    }
}
