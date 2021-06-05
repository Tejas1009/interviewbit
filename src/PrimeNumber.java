public class PrimeNumber {
    public static void main(String[] args) {
        int n = 10, c = 0, i = 1;
        int d_cnt = 0;
        while (c < n) {
            for (int j = 2; j <= i / 2 && i != 1; j++) {
                if (i % j == 0) {
                    d_cnt++;
                    break;
                }
            }
            if (i == 1 || d_cnt == 0) {
                System.out.println(i);
                c++;
            }
            d_cnt = 0;
            i += 2;//traverse only odd numbers
        }
    }
}