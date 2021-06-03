package Demo;

public class Power {

    //2^3
    //a^b
    public static int power(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        int temp = power(a, b / 2);
        if (b % 2 == 0) {
            return temp * temp;
        } else {
            return a * temp * temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }
}
