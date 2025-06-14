package Arrays;

/**
 * https://leetcode.com/problems/surrounded-regions/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 130. Surrounded Regions
 * Medium
 * Topics
 * Companies
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * <p>
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * <p>
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
 * <p>
 * Example 2:
 * <p>
 * Input: board = [["X"]]
 * <p>
 * Output: [["X"]]
 */
public class SurroundedRegions {
    public static void main(String[] args) {

    }

    public static void solve(char[][] board) {
        capture(0, 0, board);
        // Now we have captured all the 'O's that are connected to the border
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    capture(i, j, board);
                }
            }
        }

        // Now we replace all 'O's with 'X's and 'T's with 'O's
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void capture(int r, int c, char[][] board) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        capture(r + 1, c, board);
        capture(r - 1, c, board);
        capture(r, c + 1, board);
        capture(r, c - 1, board);
    }
}
