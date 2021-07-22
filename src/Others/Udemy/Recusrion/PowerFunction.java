package Others.Udemy.Recusrion;

public class PowerFunction {
    //a=2,b=1;
    //2

    //2,2
    //4

    //2,4
    //16

    //2^2 * 2^2

    //2,3
    //2^2 * 2
    public static long powerModulo(int a, int b) {
        if (b == 1) return a;
        if (b == 0) return 1;
        long temp = powerModulo(a, b / 2);
        if (b % 2 == 0) {
            return temp * temp;
        } else {
            return a * temp * temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(powerModulo(5, 2));
    }
}
