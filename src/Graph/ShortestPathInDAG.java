package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Shortest Path in Directed Acyclic Graph (DAG)
 * <p>
 * Given an Weighted DAG and a source point, the task is to find the shortest path between the source node and every other node in the graph.
 * <p>
 * Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
 * <p>
 * Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.
 * <p>
 * Example1:
 * <p>
 * Input:
 * N = 4, M = 2
 * edge = [[0,1,2],[0,2,1]]
 * Output:
 * 0 2 1 -1
 * Explanation:
 * Shortest path from 0 to 1 is 0->1 with edge weight 2.
 * Shortest path from 0 to 2 is 0->2 with edge weight 1.
 * There is no way we can reach 3, so it's -1 for 3.
 */
public class ShortestPathInDAG {

    static class Pair {
        int vertex;
        int distance;

        Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int[] result = shortestPath(6, 7, edges);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        boolean visited[] = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, stack, visited, adj);
            }
        }
        int distance[] = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        while (!stack.empty()) {
            int currNode = stack.pop();
            List<Pair> neighbours = adj.get(currNode);
            for (int i = 0; i < neighbours.size(); i++) {
                int v = neighbours.get(i).vertex;
                int wt = neighbours.get(i).distance;
                if (distance[currNode] + wt < distance[v]) {
                    distance[v] = distance[currNode] + wt;
                }
            }
        }
        return distance;
    }

    private static void topoSort(int currNode, Stack<Integer> stack, boolean visited[], List<List<Pair>> adj) {
        visited[currNode] = true;
        List<Pair> neighbours = adj.get(currNode);
        for (Pair pair : neighbours) {
            if (!visited[pair.vertex]) {
                topoSort(pair.vertex, stack, visited, adj);
            }
        }
        stack.push(currNode);
    }
}
