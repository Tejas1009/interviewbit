public class TrailingZerosInFactorial {

    public int solve(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = (res + n) / i;
        }
        return res;
    }

    public static void main(String[] args) {
        TrailingZerosInFactorial t = new TrailingZerosInFactorial();
        System.out.println(t.solve(10));
    }
}
