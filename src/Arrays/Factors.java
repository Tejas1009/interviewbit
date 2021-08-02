package Arrays;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        int A = 12;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= A / 2; i++) {
            if (A % i == 0) {
                res.add(i);
            }
        }
        res.add(A);
    }
}
