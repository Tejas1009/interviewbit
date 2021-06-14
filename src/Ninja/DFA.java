package Ninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFA {
    final long M = 1000000007;

    public int automata(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c, int D, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long[][] table = new long[a.size()][n + 1];
        for (int i = 0; i < c.size(); i++) {
            map.put(c.get(i), 1);
        }
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(i))
                table[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < a.size(); j++) {
                table[j][i] = (table[a.get(j)][i - 1] % M + table[b.get(j)][i - 1] % M) % M;
            }
        }

        return (int) (table[D][n] % M);
    }

    public static void main(String[] args) {
        DFA dfa = new DFA();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 2, 1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 0, 2));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(0));
        int d = 0;
        int n = 2;
        System.out.println(dfa.automata(a, b, c, d, n));
    }
}
