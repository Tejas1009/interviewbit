package Others.Udemy.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
BOARD GAME:
1. Given a list of words.
2. Given M*N board where every cell has one character.
Find all possible words that are part of the list and can be
formed by a sequence of adjacent characters from board.
Note that we can move to any of 8 adjacent characters,
bit a word should not have multiple instances of same cell.
 */
public class BoardGame {

    public static class TrieNode {
        Character c;
        HashMap<Character, TrieNode> childs;
        String word;
        boolean isTerminalNode;

        public TrieNode(Character c) {
            this.c = c;
            this.childs = new HashMap<>();
            this.word = null;
            this.isTerminalNode = false;
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode(null);
        }

        public void addWord(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                TrieNode node = new TrieNode(ch);
                if (!temp.childs.containsKey(ch)) {
                    temp.childs.put(ch, node);
                }
                temp = temp.childs.get(ch);
            }
            temp.isTerminalNode = true;
            temp.word = word;
        }
    }

    public void dfs(char board[][], TrieNode node, int i, int j, boolean visited[][], Set<String> output) {
        char curr_ch = board[i][j];
        if (!node.childs.containsKey(curr_ch)) {
            return;
        }
        visited[i][j] = true;
        node = node.childs.get(curr_ch);
        if (node.isTerminalNode) {
            output.add(node.word);
        }
        int dx[] = {-1, -1, 0, 1, 1, -1, 0, 1};
        int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
        for (int k = 0; k < 8; k++) {
            int ni = dx[k] + i;
            int nj = dy[k] + j;
            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && !visited[ni][nj]) {
                dfs(board, node, ni, nj, visited, output);
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        String words[] = {"SNAKE", "FOR", "QUEZ", "SNACK", "SNACKS", "GO", "TUNES", "CAT"};
        char board[][] = {
                {'S', 'E', 'R', 'T'},
                {'U', 'N', 'K', 'S'},
                {'T', 'C', 'A', 'T'}
        };
        Trie t = new Trie();
        for (String word : words) {
            t.addWord(word);
        }
        int m = board.length;
        int n = board[0].length;
        Set<String> output = new HashSet<>();
        boolean visited[][] = new boolean[m][n];
        BoardGame bg = new BoardGame();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bg.dfs(board, t.root, i, j, visited, output);
            }
        }
        for (String o : output) {
            System.out.println(o);
        }
    }
}
