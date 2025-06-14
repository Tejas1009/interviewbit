package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 */
public class MinCostConnectPoints {

    public static void main(String[] args) {
        int points[][] = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        int result = 0;
        List<Edge> adj[] = new ArrayList[points.length];
        for (int i = 0; i < points.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj[i].add(new Edge(i, j, dist));
                adj[j].add(new Edge(j, i, dist));
            }
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        boolean vis[] = new boolean[points.length];
        priorityQueue.add(new Pair(0, 0));
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            if (vis[pair.node]) continue;
            vis[pair.node] = true;
            result += pair.dist;
            for (Edge edge : adj[pair.node]) {
                if (!vis[edge.j]) {
                    priorityQueue.add(new Pair(edge.j, edge.dist));
                }
            }
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    static class Edge {
        int i;
        int j;
        int dist;

        public Edge(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
}
