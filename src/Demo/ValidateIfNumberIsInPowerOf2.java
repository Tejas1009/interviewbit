package Demo;

public class ValidateIfNumberIsInPowerOf2 {
    public static void main(String[] args) {
//        System.out.println(getBits(10));
        //System.out.println(power(2, 3));
        //System.out.println(getHighBits(7));
        System.out.println(check(7));

    }

    //check if number is power of to
    public static boolean check(int n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static int getHighBits(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }

    public static int getBits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt = n % 2 == 0 ? cnt : cnt + 1;
            n = n / 2;
        }
        return cnt;
    }

    public static int power(int n, int r) {
        if (n == 0) return 0;
        if (r == 0) return 1;
        if (r == 1) return n;
        if (n % 2 == 0) {
            return power(n, r / 2) * power(n, r / 2);
        } else {
            return n * power(n, r / 2) * power(n, r / 2);
        }
    }

}
