package Graph;

public class DSU {

    class Node {
        int rank;
        int parent;

        Node(int rank, int parent) {
            this.rank = rank;
            this.parent = parent;
        }
    }

    Node[] parent;

    int getRoot(int e) {
        if (parent[e].parent == -1)
            return e;
        return parent[e].parent = getRoot(parent[e].parent);//Path Compression
    }

    //Rank by Union
    void union(int fromP, int toP) {
        //parent[fromP] = toP;
        if (parent[fromP].rank > parent[toP].rank) {
            parent[toP].parent = fromP;
        } else if (parent[toP].rank > parent[fromP].rank) {
            parent[fromP].parent = toP;
        } else {
            parent[fromP].parent = toP;
            parent[toP].rank += 1;
        }
    }

    public boolean isCyclic(int[][] edge_list, int v) {
        parent = new Node[v];
        for (int i = 0; i < v; i++) {
            parent[i] = new Node(0, -1);
        }
        for (int[] pair : edge_list) {
            int parent1 = getRoot(pair[0]);
            int parent2 = getRoot(pair[1]);
            if (parent1 == parent2)
                return true;
            union(parent1, parent2);
        }
        return false;
    }

    public static void main(String[] args) {
        DSU d = new DSU();
        int[][] e = {
                {0, 1}, {0, 3}, {2, 3}, {1, 2}
        };
        System.out.println(d.isCyclic(e, 4));
    }
}
