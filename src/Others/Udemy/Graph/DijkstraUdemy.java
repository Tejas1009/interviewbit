package Others.Udemy.Graph;

import java.util.*;

public class DijkstraUdemy {

    static class NodeData implements Comparable<NodeData> {
        int wsf;
        String psf;
        int vertex;

        public NodeData(int wsf, String psf, int vertex) {
            this.wsf = wsf;
            this.psf = psf;
            this.vertex = vertex;
        }

        @Override
        public int hashCode() {
            return this.vertex;
        }

        @Override
        public int compareTo(NodeData other) {
            return this.wsf - other.wsf;
        }
    }

    public static int calculate(int src, int dest, int edgesWithWeight[][], int numVertices) {
        ArrayList<Map<Integer, Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adj.add(new HashMap<>());
        }
        //due to undirected graph we insert both the entries
        for (int edgeAndWeight[] : edgesWithWeight) {
            adj.get(edgeAndWeight[0]).put(edgeAndWeight[1], edgeAndWeight[2]);
            adj.get(edgeAndWeight[1]).put(edgeAndWeight[0], edgeAndWeight[2]);
        }
        boolean visited[] = new boolean[numVertices + 1];
        PriorityQueue<NodeData> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new NodeData(0, "", src));
        while (!priorityQueue.isEmpty()) {
            NodeData curr_node = priorityQueue.poll();
            if (curr_node.vertex == dest) {
                return curr_node.wsf;
            }
            if (visited[curr_node.vertex]) continue;
            visited[curr_node.vertex] = true;
            Map<Integer, Integer> neighbours = adj.get(curr_node.vertex);
            for (Map.Entry<Integer, Integer> neighbour : neighbours.entrySet()) {
                if (!visited[neighbour.getKey()]) {
                    priorityQueue.add(new NodeData(neighbour.getValue() + curr_node.wsf, curr_node + "," + neighbour.getKey(), neighbour.getKey()));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int src = 0;
        int dest = 4;
        int edgesWithWeight[][] = {
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 2},
                {3, 0, 7},
                {3, 4, 3},
                {2, 0, 4}
        };
        int numVertices = 5;
        System.out.println(calculate(src, dest, edgesWithWeight, numVertices));
        System.out.println("-------------------------------");
        System.out.println(calculate(2, dest, edgesWithWeight, numVertices));
        System.out.println("-------------------------------");
        System.out.println(calculate(4, 1, edgesWithWeight, numVertices));
    }
}
