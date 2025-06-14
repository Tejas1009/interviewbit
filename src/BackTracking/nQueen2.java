package BackTracking;

import java.util.*;

/**
 * https://leetcode.com/problems/n-queens/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 51. N-Queens
 * Hard
 * Topics
 * Companies
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [["Q"]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 9
 */
public class nQueen2 {
    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, colSet, posDiag, negDiag, n, result, board);
        return result;
    }

    private static void backtrack(int row, Set<Integer> colSet, Set<Integer> posDiag, Set<Integer> negDiag, int n, List<List<String>> result, char[][] board) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] line : board) {
                solution.add(new String(line));
            }
            result.add(solution);
            return;
        }
        //columns
        for (int c = 0; c < n; c++) {
            if (colSet.contains(c) || posDiag.contains(row - c) || negDiag.contains(row + c)) {
                continue;
            }
            board[row][c] = 'Q';
            colSet.add(c);
            posDiag.add(row - c);
            negDiag.add(row + c);
            backtrack(row + 1, colSet, posDiag, negDiag, n, result, board);
            negDiag.remove(row + c);
            posDiag.remove(row - c);
            colSet.remove(c);
            board[row][c] = '.';
        }
    }
}
