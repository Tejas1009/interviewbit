package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MinCostPath {

    class Triplets {
        int i, j, cost;

        Triplets(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    public int solve(int r, int c, ArrayList<String> directions) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Deque<Triplets> deque = new LinkedList<>();
        deque.add(new Triplets(0, 0, 0));
        boolean visited[][] = new boolean[r][c];
        visited[0][0] = true;
        while (!deque.isEmpty()) {
            Triplets t = deque.poll();
            visited[t.i][t.j] = true;
            if (t.i == r - 1 && t.j == c - 1) {
                return t.cost;
            }
            for (int i = 0; i < 4; i++) {
                Triplets t_new = new Triplets(t.i + dx[i], t.j + dy[i], 0);
                if (t_new.i >= 0 && t_new.i < r && t_new.j >= 0 && t_new.j < c && !visited[t_new.i][t_new.j]) {
                    int cost = 0;
                    char d = directions.get(t.i).charAt(t.j);
                    if (d == 'U' && dx[i] == -1 && dy[i] == 0) cost = 0;
                    else if (d == 'L' && dx[i] == 0 && dy[i] == -1) cost = 0;
                    else if (d == 'D' && dx[i] == 1 && dy[i] == 0) cost = 0;
                    else if (d == 'R' && dx[i] == 0 && dy[i] == 1) cost = 0;
                    else cost = 1;
                    t_new.cost = t.cost + cost;
                    if (cost == 0) {
                        deque.addFirst(t_new);
                    } else {
                        deque.addLast(t_new);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinCostPath m = new MinCostPath();
        ArrayList<String> dir = new ArrayList<>(Arrays.asList("RRRRD", "DLLLL", "RRRRD", "DLLLL", "RRRRR"));
        System.out.println(m.solve(5, 5, dir));
    }
}