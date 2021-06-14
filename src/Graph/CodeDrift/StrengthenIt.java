package Graph.CodeDrift;

import java.util.*;

public class StrengthenIt {

    class Component implements Comparable<Component> {
        int parent;
        int count;

        public Component(int parent, int count) {
            this.parent = parent;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Component component = (Component) o;
            return parent == component.parent;
        }

        @Override
        public int hashCode() {
            return Objects.hash(parent);
        }

        @Override
        public int compareTo(Component o) {
            return this.count - o.count;
        }
    }

    int parent[];
    ArrayList<ArrayList<Integer>> adj;

    int findParent(int e) {
        if (parent[e] == -1) return e;
        parent[e] = findParent(parent[e]);
        return parent[e];
    }

    void union(int fromP, int toP) {
        parent[fromP] = toP;
    }

    public int solve(int n, int[][] edges, int c) {
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        adj = new ArrayList<>(n + 1);
        ArrayList<Integer> self = new ArrayList<>();
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            if (edge[0] == edge[1]) {
                self.add(edge[0]);
                continue;
            }
            int fromP = findParent(edge[0]);
            int toP = findParent(edge[1]);
            if (fromP == toP) {
                continue;
            }
            union(fromP, toP);
        }
        Set<Integer> topParent = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            topParent.add(findParent(i));
        }
        return 0;
    }

    public static void main(String[] args) {
        StrengthenIt s = new StrengthenIt();
        int n = 7;
        int edges[][] = {
                {1, 2},
                {2, 3},
                {3, 1},
                {4, 5},
                {5, 6},
                {6, 1}
        };
        int c = 1;
        /*int n = 3;
        int edges[][] = {
                {1, 2},
                {2, 2},
                {2, 3},
                {3, 1}
        };
        int c = 2;*/
        System.out.println(s.solve(n, edges, c));
    }
}