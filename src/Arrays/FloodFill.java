package Arrays;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/flood-fill/description/
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(floodFill(image, 1, 1, 2));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int land = image[sr][sc];
        visited[sr][sc] = true;
        image[sr][sc] = color;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] currElement = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = currElement[0] + directions[i][0];
                int nc = currElement[1] + directions[i][1];
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == land && !visited[nr][nc]) {
                    image[nr][nc] = color;
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return image;
    }
}
