package Math;

public class PowerOfTwoInt {
    public static void main(String[] args) {
        int A = 1024000000, res = 0;
        for (int i = 2; i <= Math.sqrt(A); i++) {
            int j = 2;
            double p = Math.pow(i, j);
            while (p <= A && p > 0) {
                if (p == A) {
                    res = 1;
                    break;
                }
                j++;
                p = Math.pow(i, j);
            }
            if (res > 0)
                break;
        }
        System.out.println(res);
    }
}
