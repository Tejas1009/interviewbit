package Graph;

public class CycleInUndirectedGraph {

    int parent[];

    int findParent(int e) {
        if (parent[e] == -1) return e;
        parent[e] = findParent(parent[e]);
        return parent[e];
    }

    void union(int fromP, int toP) {
        parent[fromP] = toP;
    }

    public int solve(int a, int mat[][]) {
        parent = new int[a + 1];
        for (int i = 1; i <= a; i++) parent[i] = -1;
        for (int[] pair : mat) {
            int fromP = findParent(pair[0]);
            int toP = findParent(pair[1]);
            if (fromP == toP) {
                return 1;
            }
            union(fromP, toP);
        }
        return 0;
    }

    public static void main(String[] args) {
        CycleInUndirectedGraph c = new CycleInUndirectedGraph();
        int m[][] = {
                {1, 2},
                {1, 3},
                {2, 3},
                {1, 4},
                {4, 5}
        };
        System.out.println(c.solve(5, m));
    }
}