package Graph;

import java.util.ArrayList;

public class LargestDistanceBetweenNodesOfTree {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;
    int res;

    private void recur(int curr, int cnt, String osf) {
        if (visited[curr]) {
            return;
        }
        if (cnt > res) {
            res = cnt;
        }
        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            recur(adj.get(curr).get(i), cnt + 1, osf + adj.get(curr).get(i));
        }
        visited[curr] = false;
    }

    public int solve(int[] a) {
        res = 0;
        visited = new boolean[a.length];
        adj = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                continue;
            }
            adj.get(i).add(a[i]);
            adj.get(a[i]).add(i);
        }
        for (int i = 0; i < a.length; i++) {
            recur(i, 0, i + "");
        }
        return res;
    }

    public static void main(String[] args) {
        LargestDistanceBetweenNodesOfTree l = new LargestDistanceBetweenNodesOfTree();
        int a[] = {-1, 0, 0, 0, 3};
        System.out.println(l.solve(a));
    }
}
