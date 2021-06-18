package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {
    private ArrayList<String> getBinaryCode(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList("0"));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1"));
        }
        ArrayList<String> pres = getBinaryCode(n - 1);
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < pres.size(); i++) {
            res.add("0" + pres.get(i));
        }
        for (int i = pres.size() - 1; i >= 0; i--) {
            res.add("1" + pres.get(i));
        }
        return res;
    }

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<String> r = getBinaryCode(n);
        for (int i = 0; i < r.size(); i++) {
            res.add(Integer.parseInt(r.get(i), 2));
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        gc.grayCode(4);
    }
}