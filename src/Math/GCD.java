package Math;

public class GCD {

    public int gcd(int A, int B) {
        if (A <= 0) {
            return B;
        }
        return gcd(B % A, A);
    }

    public static void main(String[] args) {
        GCD g = new GCD();
        System.out.println(g.gcd(9, 6));
    }
}
