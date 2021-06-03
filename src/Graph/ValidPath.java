package Graph;

import java.util.LinkedList;
import java.util.Queue;


/*Valid Path
        Asked in:
        Morgan Stanley
        Amazon
        Codenation
        Directi
        Problem Setter: glowing_glare Problem Tester: dhruvi
        There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
        Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

        Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.


        Input Format

        1st argument given is an Integer x.
        2nd argument given is an Integer y.
        3rd argument given is an Integer N, number of circles.
        4th argument given is an Integer R, radius of each circle.
        5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
        6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
        Output Format

        Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
        Constraints

        0 <= x, y, R <= 100
        1 <= N <= 1000
        Center of each circle would lie within the grid
        For Example

        Input:
        x = 2
        y = 3
        N = 1
        R = 1
        A = [2]
        B = [3]
        Output:
        NO

        Explanation:
        There is NO valid path in this case*/
public class ValidPath {

    class Pair {
        int p;
        int q;

        Pair(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    private void markPointsInsideCircle(boolean mat[][], int a[], int b[], int x, int y, int r) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k < a.length; k++) {
                    if (((i - a[k]) * (i - a[k]) + (j - b[k]) * (j - b[k])) <= r * r) {
                        mat[i][j] = true;
                        break;
                    }
                }
            }
        }
    }

    public String solve(int x, int y, int n, int r, int a[], int b[]) {
        String res = "NO";
        boolean mat[][] = new boolean[x + 1][y + 1];
        markPointsInsideCircle(mat, a, b, x, y, r);
        if (mat[0][0]) return "NO";
        int dx[] = {-1, 1, 0, 0, 1, 1, -1, -1};
        int dy[] = {0, 0, -1, 1, -1, 1, -1, 1};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        mat[0][0] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            //System.out.println(pair.p + "-" + pair.q);
            if (pair.p == x && pair.q == y) {
                return "YES";
            }
            for (int i = 0; i < 8; i++) {
                Pair newP = new Pair(dx[i] + pair.p, dy[i] + pair.q);
                if (newP.p >= 0 && newP.p <= x && newP.q >= 0 && newP.q <= y && mat[newP.p][newP.q] == false) {
                    queue.add(newP);
                    mat[newP.p][newP.q] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ValidPath v = new ValidPath();
        int a[] = {};
        int b[] = {};
        System.out.println(v.solve(2, 3, 1, 1, a, b));
    }
}