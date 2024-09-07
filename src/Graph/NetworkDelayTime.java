package Graph;

import java.util.*;

/**
 * 743. Network Delay Time
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
        int n = 3, k = 1;
        System.out.println(networkDelayTime(times, n, k));
    }

    static class Data {
        private int v;
        private int distance;

        public Data(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int delay = Integer.MIN_VALUE;
        List<List<Data>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Data(times[i][1], times[i][2]));
        }
        int[] distance = new int[n + 1];
        Set<Integer> visited = new HashSet<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.add(new Data(k, 0));
        while (!pq.isEmpty()) {
            Data currNode = pq.remove();
            visited.add(currNode.v);
            List<Data> neighbours = adj.get(currNode.v);
            for (Data neighbour : neighbours) {
                int newNode = neighbour.v;
                if (visited.contains(newNode)) continue;
                int requiredDistance = currNode.distance + neighbour.distance;
                if (requiredDistance < distance[newNode]) {
                    distance[newNode] = Math.min(requiredDistance, distance[newNode]);
                    pq.add(new Data(newNode, requiredDistance));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            delay = Math.max(delay, distance[i]);
        }
        return delay;
    }
}
