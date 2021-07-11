package Others.Udemy.BinarySearch;

public class SquareRoot {

    public static double sqrt(int n, int p) {
        //calculate pre decimal integer
        double res = -1;
        int s = 0, e = n;
        while (s <= e) {
            int m = (s + e) / 2;
            if (m * m == n) {
                return m;
            } else if (m * m < n) {
                res = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        //calculate places
        double inc = 0.1;
        for (int i = 1; i <= p; i++) {
            while ((res * res) <= n) {
                res += inc;
            }
            res = res - inc;
            inc = inc / 10.0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(10, 1));
        System.out.println(sqrt(10, 3));
    }
}
