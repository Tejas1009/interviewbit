package Tree;

import java.util.ArrayList;
import java.util.List;


/**
 * 212. Word Search II
 * Hard
 * Topics
 * Companies
 * Hint
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [['o','a','a','n'],['e','t','a','e'],['i','h','k','r'],['i','f','l','v']], words = ['oath','pea','eat','rain']
 * Output: ['eat','oath']
 * Example 2:
 * <p>
 * <p>
 * Input: board = [['a','b'],['c','d']], words = ['abcb']
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class WordSearch2Trie {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> result = findWords(board, words);
        result.forEach(System.out::println);
    }

    static class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;

        TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = addWords(words);
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (root.children[board[r][c] - 'a'] != null) {
                    dfs(r, c, board, result, root, visited, "");
                }
            }
        }
        return result;
    }

    private static void dfs(int r, int c, char[][] board, List<String> result, TrieNode node, boolean[][] visited, String
            word) {
        if (node == null || r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]) {
            return;
        }
        char currentChar = board[r][c];
        if (node.children[currentChar - 'a'] == null) {
            return;
        }
        node = node.children[currentChar - 'a'];
        visited[r][c] = true;
        word += currentChar;
        if (node.isEnd) {
            result.add(word);
            node.isEnd = false;
        }
        dfs(r - 1, c, board, result, node, visited, word);
        dfs(r + 1, c, board, result, node, visited, word);
        dfs(r, c - 1, board, result, node, visited, word);
        dfs(r, c + 1, board, result, node, visited, word);
        visited[r][c] = false;
    }

    private static TrieNode addWords(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWord(word, root);
        }
        return root;
    }

    private static void addWord(String word, TrieNode root) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
}
