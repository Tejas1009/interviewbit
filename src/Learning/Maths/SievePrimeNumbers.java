package Learning.Maths;

import java.util.Arrays;

public class SievePrimeNumbers {

    public boolean isPrime(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2 * i; j <= n; j = j + i) {
                isPrime[j] = false;
            }
        }
        for (int i = 0; i <= n; i++) System.out.println(isPrime[i] + ": " + i);
        return isPrime[n];
    }

    public static void main(String[] args) {
        SievePrimeNumbers s = new SievePrimeNumbers();
        System.out.println(s.isPrime(20));
    }
}
