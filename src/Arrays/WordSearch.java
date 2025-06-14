package Arrays;
//https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=oizxjoit

/**
 * 79. Word Search
 * Medium
 * Topics
 * Companies
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] borad = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(borad, word));
    }

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int currIndex) {
        if (currIndex == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(currIndex)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean res = dfs(board, word, i + 1, j, currIndex + 1) ||
                dfs(board, word, i - 1, j, currIndex + 1) ||
                dfs(board, word, i, j + 1, currIndex + 1) ||
                dfs(board, word, i, j - 1, currIndex + 1);
        board[i][j] = temp;
        return res;
    }

}
