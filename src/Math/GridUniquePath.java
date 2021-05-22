package Math;

public class GridUniquePath {
    static int paths = 0;

    public static void getPaths(int i, int j, int n, int m) {
        if (i == m - 1 && j == n - 1) {
            paths++;
            return;
        }
        if (i > m || j > n) {
            return;
        }
        getPaths(i + 1, j, n, m);
        getPaths(i, j + 1, n, m);
    }

    public static void calculatePaths(int A, int B) {
        if (A <= 1 || B <= 1) {
            System.out.println(1);
            return;
        }
        getPaths(0, 0, A, B);
    }

    public static void main(String[] args) {
        int A = 12;
        int B = 5;
        calculatePaths(A, B);
        System.out.println(paths);
    }
}
