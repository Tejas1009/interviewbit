package Graph;

import java.util.ArrayList;

/*
Path with good nodes!
        Asked in:
        Tower Research Capital
        Problem Description

        Given a tree with N nodes labelled from 1 to N.

        Each node is either good or bad denoted by binary array A of size N where if A[i] is 1 then ithnode is good else if A[i] is 0 then ith node is bad.

        Also the given tree is rooted at node 1 and you need to tell the number of root to leaf paths in the tree that contain not more than C good nodes.

        NOTE:

        Each edge in the tree is bi-directional.


        Problem Constraints
        2 <= N <= 105

        A[i] = 0 or A[i] = 1

        0 <= C <= N



        Input Format
        First argument is an binary integer array A of size N.

        Second argument is a 2-D array B of size (N-1) x 2 denoting the edge of the tree.

        Third argument is an integer C.



        Output Format
        Return an integer denoting the number of root to leaf paths in the tree that contain not more than C good nodes.



        Example Input
        Input 1:

        A = [0, 1, 0, 1, 1, 1]
        B = [  [1, 2]
        [1, 5]
        [1, 6]
        [2, 3]
        [2, 4]
        ]
        C = 1


        Example Output
        Output 1:

        3*/
public class PathWithGoodNodes {
    ArrayList<ArrayList<Integer>> adj;
    int res;
    boolean[] visited;

    private void isGoodPath(int curr, int c, int a[], int gn, String osf) {
        if (visited[curr] || gn > c) return;
        if (adj.get(curr).size() == 1) {
            //System.out.println(osf);
            res++;
            return;
        }
        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            isGoodPath(adj.get(curr).get(i), c, a, gn + a[adj.get(curr).get(i) - 1], osf + adj.get(curr).get(i));
        }
        visited[curr] = false;
    }

    public int solve(int a[], int edges[][], int c) {
        res = 0;
        adj = new ArrayList<>(a.length + 1);
        visited = new boolean[a.length + 1];
        for (int i = 0; i <= a.length; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
//        for (int i = 1; i <= a.length; i++) {
        isGoodPath(1, c, a, a[0], String.valueOf(1));
//        }
        return res;
    }

    public static void main(String[] args) {
        PathWithGoodNodes p = new PathWithGoodNodes();
        int a[] = {1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1};
        int b[][] = {
                {10, 6},
                {3, 2},
                {12, 7},
                {9, 5},
                {2, 1},
                {8, 3},
                {7, 1},
                {4, 2},
                {6, 3},
                {11, 4},
                {5, 3},
                {13, 11}
        };
        int c = 7;
        System.out.println(p.solve(a, b, c));
    }
}
