package Graph.CodeDrift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    ArrayList<Map<Integer, Integer>> adj;
    int start, end;
    boolean[] visited;
    int minWeight = Integer.MAX_VALUE;
    int minPath = Integer.MAX_VALUE;
    int minEdgeWeight = Integer.MAX_VALUE;

    private void dfs(int curr, int weight, int edgeWeight) {
        if (visited[curr] || weight > minWeight) {
            minEdgeWeight = Integer.MAX_VALUE;
            return;
        }
        minEdgeWeight = Math.min(minEdgeWeight, edgeWeight);
        if (curr == end && weight <= minWeight) {
            if (weight < minWeight) minPath = Integer.MAX_VALUE;
            minWeight = weight;
            minPath = Math.min(minPath, minEdgeWeight);
            minEdgeWeight = Integer.MAX_VALUE;
            return;
        }
        visited[curr] = true;
        for (Map.Entry<Integer, Integer> entry : adj.get(curr).entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            dfs(k, weight + v, v);
        }
        visited[curr] = false;
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int houses, final int[][] edgesWithWeight, final int start, final int end) {
        this.start = start;
        this.end = end;
        adj = new ArrayList<>();
        visited = new boolean[houses + 1];
        for (int i = 0; i <= houses; i++) {
            adj.add(new HashMap<>());
        }
        for (int i = 0; i < edgesWithWeight.length; i++) {
            adj.get(edgesWithWeight[i][0]).put(edgesWithWeight[i][1], edgesWithWeight[i][2]);
            adj.get(edgesWithWeight[i][1]).put(edgesWithWeight[i][0], edgesWithWeight[i][2]);
        }
        dfs(start, 0, Integer.MAX_VALUE);
        return minPath;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int houses = 7;
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
        int dest = 3;
/*        int houses = 4;
        int edges[][] = {
                {1, 2, 1},
                {2, 3, 1},
                {1, 3, 2},
                {3, 4, 1}
        };
        int src = 2;
        int dest = 4;*/
        /*int houses = 4;
        int edges[][] = {
                {2, 3, 1},
                {3, 1, 9},
                {2, 4, 3},
                {4, 1, 6}
        };
        int src = 2;
        int dest = 1;*/
        System.out.println(s.solve(houses, edges, src, dest));
    }
}

