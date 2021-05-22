package Math;

public class IntegerPalindrome {
    public static void main(String[] args) {
        int n = 1000000001;
        if (n < 0) {
            System.out.println(false);
        }
        if (n < 10) {
            System.out.println(true);
        }
        int divisor = 1;
        boolean res = true;
        while (n / divisor >= 10) {
            divisor = divisor * 10;
        }

        while (n > 0) {
            int f = n / divisor;
            int l = n % 10;
            n = (n % divisor) / 10;
            divisor = divisor / 100;
            if (f != l) {
                res = false;
                break;
            }
        }
        System.out.println(res);
    }
}
