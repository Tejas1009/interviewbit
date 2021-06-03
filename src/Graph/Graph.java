package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int numVertices;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    public Graph(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int source, int destination) {
        adjLists[source].add(destination);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator itr = adjLists[vertex].listIterator();
        while (itr.hasNext()) {
            int adj_node = (int) itr.next();
            if (!visited[adj_node])
                DFS(adj_node);
        }
    }

    // Function which prints BFS traversal from a given source 's'
    void BFS(int s) {
        // mark all vertices as false, (i.e. they are not visited yet)
        boolean visited[] = new boolean[numVertices];

        // Create a new queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() > 0) {
            // pop a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            //Traverse all the adjacent vertices of current vertex,
            //check if they are not visited yet, mark them visited and push them into the queue.
            Iterator<Integer> it = adjLists[s].listIterator();
            while (it.hasNext() == true) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");

        g.DFS(0);
        System.out.println("Following is BFS:");
        g.BFS(0);
    }
}
