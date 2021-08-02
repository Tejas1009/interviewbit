package Others.Udemy.Graph;

import java.util.PriorityQueue;

public class ShortestGridPath {

    public static class NodeData implements Comparable<NodeData> {
        int value;
        int i;
        int j;
        String psf;
        int wsf;

        public NodeData(int value, int i, int j, String psf, int wsf) {
            this.value = value;
            this.i = i;
            this.j = j;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(NodeData o) {
            return this.wsf - o.wsf;
        }
    }

    public static int shortest_path(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        PriorityQueue<NodeData> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new NodeData(grid[0][0], 0, 0, grid[0][0] + ",", grid[0][0]));
        visited[0][0] = true;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        while (!priorityQueue.isEmpty()) {
            NodeData curr_node = priorityQueue.poll();
            visited[curr_node.i][curr_node.j] = true;
            if (curr_node.i == m - 1 && curr_node.j == n - 1) {
                System.out.println(curr_node.psf);
                return curr_node.wsf;
            }
            for (int k = 0; k < 4; k++) {
                int ni = curr_node.i + dx[k];
                int nj = curr_node.j + dy[k];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && !visited[ni][nj]) {
                    NodeData neighbour = new NodeData(curr_node.value, ni, nj, curr_node.psf + grid[ni][nj] + ", ", curr_node.wsf + grid[ni][nj]);
                    priorityQueue.add(neighbour);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int grid[][] = {
                {31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}
        };
        System.out.println(shortest_path(grid));
    }
}
