package Others.Udemy.String;

import java.util.ArrayList;
import java.util.Collections;

public class SortSubSequences {

    private static void subsequence(String str, String osf, ArrayList<String> res) {
        if (str.length() == 0) {
            res.add(osf);
            return;
        }
        char ch = str.charAt(0);
        str = str.substring(1);
        subsequence(str, osf + ch, res);
        subsequence(str, osf, res);
    }

    public static ArrayList<String> get(String str) {
        ArrayList<String> res = new ArrayList<>();
        subsequence(str, "", res);
        Collections.sort(res, (x, y) -> {
            if (x.length() == y.length()) {
                return x.compareTo(y);
            }
            return x.length() - y.length();
        });
        return res;
    }

    public static void main(String[] args) {
        get("abcd").forEach(System.out::println);
        System.out.println("-------------");
    }
}
