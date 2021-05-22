package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

        N Queens: Example 1

        Given an integer n, return all distinct solutions to the n-queens puzzle.

        Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

        For example,
        There exist two distinct solutions to the 4-queens puzzle:

        [
        [".Q..",  // Solution 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // Solution 2
        "Q...",
        "...Q",
        ".Q.."]
        ]*/

public class nQueen {

    public void placeQueen(int[][] board, int row, String osf, ArrayList<ArrayList<String>> res) {
        if (row == board.length) {
            //System.out.println(osf);
            ArrayList<String> sol = new ArrayList<>();
            for (int k = 0; k < board.length; k++) {
                String r = "";
                for (int m = 0; m < board.length; m++) {
                    r += board[k][m] == 1 ? "Q" : ".";
                }
                sol.add(r);
            }
            res.add(sol);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (safeToPlaceQueen(board, row, i)) {
                board[row][i] = 1;
                placeQueen(board, row + 1, osf + row + "," + i + "|", res);
                board[row][i] = 0;
            }
        }

    }

    private boolean safeToPlaceQueen(int[][] board, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if (n == 1) {
            res.add(new ArrayList<>(Arrays.asList("Q")));
            return res;
        }
        if (n < 4) {
            return res;
        }
        int board[][] = new int[n][n];
        placeQueen(board, 0, "", res);
        return res;
    }

    public static void main(String[] args) {
        nQueen n = new nQueen();
        n.solveNQueens(4);
    }
}