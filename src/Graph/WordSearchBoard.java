package Graph;

import java.util.HashSet;

public class WordSearchBoard {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean find(char[][] mat, Pair p, String b, int level) {
        if (level == b.length()) {
            return true;
        }
        if (p.x < 0 || p.x >= mat.length || p.y < 0 || p.y >= mat[0].length) return false;
        if (mat[p.x][p.y] == b.charAt(level)) {
            return find(mat, new Pair(p.x - 1, p.y), b, level + 1) ||
                    find(mat, new Pair(p.x + 1, p.y), b, level + 1) ||
                    find(mat, new Pair(p.x, p.y - 1), b, level + 1) ||
                    find(mat, new Pair(p.x, p.y + 1), b, level + 1);
        } else {
            return false;
        }
    }

    public int exist(String[] A, String B) {
        if (B.length() <= 0) return 0;
        char[][] mat = new char[A.length][A[0].length()];
        char firstLetter = B.charAt(0);
        HashSet<Pair> set = new HashSet<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = A[i].charAt(j);
                if (firstLetter == mat[i][j]) {
                    set.add(new Pair(i, j));
                }
            }
        }
        for (Pair p : set) {
            if (find(mat, p, B, 0)) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordSearchBoard w = new WordSearchBoard();
        String[] str = {"ABCE", "SFCS", "ADEE"};
        System.out.println(w.exist(str, "ABCD"));
    }
}
