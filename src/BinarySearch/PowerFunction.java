package BinarySearch;

public class PowerFunction {
    public int pow(int x, int n, int d) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return Math.floorMod(x, d);
        }
        if (n % 2 == 0) {
            int temp = pow(x, n / 2, d);
            return (temp * temp) % d;
        } else {
            int temp = pow(x, (n - 1) / 2, d);
            if (n > 0) {
                return Math.floorMod(x * temp * temp, d);
            } else {
                return Math.floorMod((temp * temp) / n, d);
            }
        }
    }

    public static void main(String[] args) {
        PowerFunction pf = new PowerFunction();
        int res = pf.pow(71045970, 41535484, 64735492);
        System.out.println(res);
    }
}