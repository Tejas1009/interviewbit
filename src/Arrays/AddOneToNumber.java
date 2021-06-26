package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 4, 4, 6, 0, 9, 6, 5, 1));
        boolean carry = false;
        A.set(A.size() - 1, A.get(A.size() - 1) + 1);
        carry = A.get(A.size() - 1) % 10 == 0 ? true : false;
        if (carry)
            A.set(A.size() - 1, 0);

        for (int i = A.size() - 2; i >= 0; i--) {
            if (carry) {
                A.set(i, A.get(i) + 1);
                carry = A.get(i) % 10 == 0 ? true : false;
                A.set(i, A.get(i) % 10);
            }
        }

        if (carry) {
            A.add(0, 1);
        } else {
            while (A.get(0) == 0) {
                A.remove(0);
            }
        }
        System.out.println(A);
    }
}
