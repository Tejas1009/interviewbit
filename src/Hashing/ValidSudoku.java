package Hashing;
/*Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

        The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.



        The input corresponding to the above configuration :

        ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
        A partially filled sudoku which is valid.

        Note:
        A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
        Return 0 / 1 ( 0 for false, 1 for true ) for this problem*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {

    public int isValidSudoku(final List<String> a) {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = a.get(i).charAt(j);
            }
        }
        return isValid(board) ? 1 : 0;
    }

    public boolean isValid(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!seen.add(ch + "found in row " + i) ||
                            !seen.add(ch + "found in col " + j) ||
                            !seen.add(ch + "found in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        int res = vs.isValidSudoku(new ArrayList<>(Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")));
        System.out.println(res);
    }
}
