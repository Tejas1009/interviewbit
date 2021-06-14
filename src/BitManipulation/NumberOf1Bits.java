package BitManipulation;

public class NumberOf1Bits {
    public int numSetBits(long n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1Bits n = new NumberOf1Bits();
        System.out.println(n.numSetBits(11));
    }
}
