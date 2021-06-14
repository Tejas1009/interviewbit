package Graph.CodeDrift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    class Pair implements Comparable<Pair> {
        int v;
        int wsf;
        String psf;

        Pair(int v, int wsf, String psf) {
            this.v = v;
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    ArrayList<Map<Integer, Integer>> adj;

    public int solve(final int houses, final int[][] edgesWithWeight, final int start, final int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0, "" + start));
        boolean[] visited = new boolean[houses + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= houses; i++) {
            adj.add(new HashMap<>());
        }
        for (int i = 0; i < edgesWithWeight.length; i++) {
            adj.get(edgesWithWeight[i][0]).put(edgesWithWeight[i][1], edgesWithWeight[i][2]);
            adj.get(edgesWithWeight[i][1]).put(edgesWithWeight[i][0], edgesWithWeight[i][2]);
        }
        while (pq.size() > 0) {
            Pair r = pq.remove();
            if (visited[r.v]) continue;
            visited[r.v] = true;
            System.out.print(r.psf);
            System.out.println();
            for (Map.Entry<Integer, Integer> entry : adj.get(r.v).entrySet()) {
                if (!visited[entry.getKey()]) {
                    pq.add(new Pair(entry.getKey(), entry.getValue() + r.wsf, r.psf + entry.getKey()));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
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
        Dijkstra d = new Dijkstra();
        d.solve(houses, edges, src, dest);
    }
}
