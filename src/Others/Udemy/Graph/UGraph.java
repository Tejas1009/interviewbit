package Others.Udemy.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UGraph {
    ArrayList<LinkedList<Integer>> adjList;
    int numVertices;
    boolean visited[];

    public UGraph(int numVertices) {
        this.adjList = new ArrayList<>(numVertices);
        this.numVertices = numVertices;
        this.visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList.add(i, new LinkedList<Integer>());
        }
    }

    public void addEdge(int source, int dest, boolean unDirected) {
        adjList.get(source).add(dest);
        if (unDirected) {
            adjList.get(dest).add(source);
        }
    }

    public void printAdjList() {
        //Iterate over all rows
        for (int v = 0; v < numVertices; v++) {
            System.out.print("Vertex: " + v + " neighbours: ");
            for (Integer neighbour : adjList.get(v)) {
                System.out.print(neighbour + ",");
            }
            System.out.println();
        }
    }

    public void DFS(int source) {
        visited[source] = true;
        System.out.print(source + "-->");
        for (int neighbour : adjList.get(source)) {
            if (!visited[neighbour]) {
                DFS(neighbour);
            }
        }
    }

    public void BFS(int source) {
        Queue<Integer> queue = new LinkedList<>();
        int parent[] = new int[numVertices];//storing immediate parent so that we can track back shortest distance from dest node to source node
        int distance[] = new int[numVertices];//storing distance from source node to all other node
        queue.add(source);
        visited[source] = true;
        parent[source] = source;
        distance[source] = 0;
        while (!queue.isEmpty()) {
            int curr_elem = queue.poll();
            System.out.print(curr_elem + "-->");
            for (int neighbour : adjList.get(curr_elem)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    parent[neighbour] = curr_elem;
                    distance[neighbour] = distance[curr_elem] + 1;
                }
            }
        }
        System.out.println("-----------------------------");
        //print the shortest distance
        for (int v = 0; v < numVertices; v++) {
            System.out.println("Shortest dist to " + v + " is: " + distance[v]);
        }
        System.out.println("-----------------------------");
        //print path from a source to any destination
        for (int v = 0; v < numVertices; v++) {
            System.out.print("Path from " + source + " to " + v + " is: ");
            path(parent, v);
            System.out.println();
        }
    }

    private void path(int parent[], int v) {
        if (v == parent[v]) return;
        System.out.print("-->" + v);
        path(parent, parent[v]);
    }

    public static void main(String[] args) {
        UGraph g = new UGraph(7);
        g.addEdge(0, 1, true);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 5, true);
        g.addEdge(5, 6, true);
        g.addEdge(4, 5, true);
        g.addEdge(0, 4, true);
        g.addEdge(3, 4, true);
        //g.printAdjList();
        //g.BFS(1);//1-->0-->2-->4-->3-->5-->6
        g.DFS(1);//1-->0-->4-->5-->3-->2-->6-->
    }

}
