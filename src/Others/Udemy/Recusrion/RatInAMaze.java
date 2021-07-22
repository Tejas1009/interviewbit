package Others.Udemy.Recusrion;

import java.util.ArrayList;

//
public class RatInAMaze {
    private static int dx[] = {0, 1};
    private static int dy[] = {1, 0};
    private static ArrayList<Integer> res;

    private static void recur(char mat[][], int n, int i, int j) {
        if (i == n) return;
        if (j == n) return;
        if (mat[i][j] == 'X') return;
        if (i == n - 1 && j == n - 1) {
            res.add(n * n);
            res.forEach(System.out::println);
            return;
        }
        for (int x = 0; x < 2; x++) {
            res.add((i * n) + (j + 1));
            recur(mat, n, dx[x] + i, dy[x] + j);
            res.remove(res.size() - 1);
        }
    }

    public static ArrayList<Integer> findPath(int n, char mat[][]) {
        res = new ArrayList<>();
        recur(mat, n, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O'},
                {'O', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O'}
        };
        findPath(mat.length, mat);
    }
}
