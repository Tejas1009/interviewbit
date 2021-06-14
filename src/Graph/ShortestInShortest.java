package Graph;

import java.util.*;

public class ShortestInShortest {
    ArrayList<Map<Integer, Integer>> adj;
    int start, end;
    boolean[] visited;
    int minWeight = Integer.MAX_VALUE;
    int minPath = Integer.MAX_VALUE;


    public int solve(final int houses, final int[][] edgesWithWeight, final int start, final int end) {
        this.start = start;
        this.end = end;
        adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> parent = new ArrayList<>(houses + 1);
        visited = new boolean[houses + 1];
        for (int i = 0; i <= houses; i++) {
            adj.add(new HashMap<>());
            parent.add(new ArrayList<>());
        }
        for (int i = 0; i < edgesWithWeight.length; i++) {
            adj.get(edgesWithWeight[i][0]).put(edgesWithWeight[i][1], edgesWithWeight[i][2]);
            adj.get(edgesWithWeight[i][1]).put(edgesWithWeight[i][0], edgesWithWeight[i][2]);
        }
        dfs(start, start + "", 0, parent);
        return minPath;
    }

    private void dfs(int curr, String osf, int weight, ArrayList<ArrayList<Integer>> parent) {
        if (visited[curr]) return;
        if (curr == end && weight <= minWeight) {
            System.out.println(osf + " Weight: " + weight);
            if (weight < minWeight) minPath = Integer.MAX_VALUE;
            minWeight = weight;
            int nextParent = end;
            while (nextParent != -1) {
                if (parent.get(nextParent) != null && parent.get(nextParent).size() > 0) {
                    int p = parent.get(nextParent).get(0);
                    Map<Integer, Integer> map = adj.get(nextParent);

                    minPath = map.get(p) < minPath ? map.get(p) : minPath;
                    nextParent = p;
                } else {
                    nextParent = -1;
                }
            }
            return;
        }
        visited[curr] = true;
        /*for (int i = 0; i < adj.get(curr).size(); i++) {
            AdjWeight k = adj.get(curr).get(i);
            HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) adj.get(curr);
            parent.get(k.a).add(curr);
            dfs(k.a, osf + "->" + k.a, weight + map.get(), parent);
            parent.get(k.a).remove(parent.get(curr).size() - 1);
        }*/
        for (Map.Entry<Integer, Integer> entry : adj.get(curr).entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            parent.get(k).add(curr);
            dfs(k, osf + "->" + k, weight + v, parent);
            parent.get(k).remove(parent.get(k).size() - 1);
        }
        visited[curr] = false;
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> parent, int n, int start, int end) {
        int[] dist = new int[n + 1];
        for (int i = 0; i < n; i++) dist[n] = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        parent.get(start).add(-1);
        dist[start] = 0;
        visited = new boolean[n + 1];
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == end) System.out.println(u);
            visited[u] = true;
            for (int v : adj.get(u)) {
                if (visited[v]) continue;
                q.add(v);
            }
        }
    }

    public static void main(String[] args) {
        ShortestInShortest s = new ShortestInShortest();
        /*int houses = 7;
        int edges[][] = {
                {1, 2, 2},
                {2, 3, 8},
                {1, 7, 3},
                {7, 4, 2},
                {4, 3, 5},
                {1, 5, 3},
                {5, 3, 7},
                {1, 6, 1}
        };
        int src = 1;
        int dest = 3;*/
/*        int houses = 4;
        int edges[][] = {
                {1, 2, 1},
                {2, 3, 1},
                {1, 3, 2},
                {3, 4, 1}
        };
        int src = 2;
        int dest = 4;*/
        int houses = 4;
        int edges[][] = {
                {2, 3, 1},
                {3, 1, 9},
                {2, 4, 3},
                {4, 1, 6}
        };
        int src = 2;
        int dest = 1;
        System.out.println(s.solve(houses, edges, src, dest));
    }
}