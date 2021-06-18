package BackTracking;

import java.util.ArrayList;

public class StringPermutations {
    static int cnt = 0;

    private void permute(String s, ArrayList<String> res, String osf, boolean visited[]) {
        cnt++;
        if (osf.length() == s.length()) {
            System.out.println(osf);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permute(s, res, osf + s.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    private void permuteSwap(String s, int l, int r) {
        cnt++;
        if (l == r) {
            System.out.println(s);
            return;
        }
        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            permuteSwap(s, l + 1, r);
            s = swap(s, l, i);
        }
    }

    private String swap(String s, int l, int r) {
        char[] ch = s.toCharArray();
        char temp = s.charAt(l);
        ch[l] = ch[r];
        ch[r] = temp;
        return String.valueOf(ch);

    }

    public ArrayList<String> permutations(String s) {
        ArrayList<String> res = new ArrayList<>();
        boolean visited[] = new boolean[s.length()];
        permute(s, res, "", visited);
        //permuteSwap(s, 0, s.length() - 1);
        System.out.println(cnt);
        return res;
    }

    public static void main(String[] args) {
        StringPermutations sp = new StringPermutations();
        sp.permutations("ABC");
    }
}
