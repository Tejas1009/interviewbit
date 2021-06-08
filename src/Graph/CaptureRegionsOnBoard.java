package Graph;
/*Capture Regions on Board
        Asked in:
        Google
        Problem Description

        Given a 2D character matrix A of size N x M, containing 'X' and 'O', capture all regions surrounded by 'X'.

        A region is captured by flipping all 'O's into 'X's in that surrounded region.



        Problem Constraints
        1 <= N, M <= 103



        Input Format
        First and only argument 2D character matrix A of size N X M.



        Output Format
        Make changes to the the input only as matrix is passed by reference.



        Example Input
        Input 1:

        A = [  [X, X, X, X],
        [X, O, O, X],
        [X, X, O, X],
        [X, O, X, X]
        ]


        Example Output
        Output 1:

        A = [  [X, X, X, X],
        [X, X, X, X],
        [X, X, X, X],
        [X, O, X, X]
        ]


        Example Explanation
        Explanation 1:

        'O' in (4,2) is not surrounded by X from below.*/

import java.util.ArrayList;

public class CaptureRegionsOnBoard {

    public void solve(ArrayList<ArrayList<Character>> mat) {
        int m = mat.size(), n = mat.get(0).size();
        for (int i = 0; i < n; i++) {
            dfs(mat, 0, i);
            dfs(mat, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(mat, i, 0);
            dfs(mat, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat.get(i).get(j) == 'O') mat.get(i).set(j, 'X');
                if (mat.get(i).get(j) == '1') mat.get(i).set(j, 'O');
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> mat, int m, int n) {
        if (mat.get(m).get(n) == 'O') {
            mat.get(m).set(n, '1');
        } else {
            return;
        }

        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            if ((m + dx[i]) >= 0 && (m + dx[i]) < mat.size() && (n + dy[i]) >= 0 && (n + dy[i]) < mat.get(0).size()) {
                dfs(mat, dx[i] + m, dy[i] + n);
            }
        }
    }

    public static void main(String[] args) {
        CaptureRegionsOnBoard c = new CaptureRegionsOnBoard();
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        //c.solve(mat);
    }
}
