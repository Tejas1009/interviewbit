package Others.ULA;

import java.util.ArrayList;
import java.util.Scanner;

public class RestrictedMovements {

    public static void main(String[] args) {
       /* Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        while (tc > 0) {
            int input = s.nextInt();
            //System.out.println(divSum(input));
            tc--;
        }*/
        int A = 5;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (A % i == 0) {
                System.out.println(i);
            }
        }

    }
}
