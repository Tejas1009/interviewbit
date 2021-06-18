package Others;

public class Fibonacci {
    //ip: 4

    //1
    //2
    //3
    //5
    //8
    public static int fib(int n) {
        int temp[] = new int[n + 1];
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i <= n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n];
    }

    public static int fibRecur(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fibRecur(n - 1) + fibRecur(n - 2);
    }

    public static void main(String[] args) {
        //System.out.println(Fibonacci.fib(5));
        System.out.println(Fibonacci.fibRecur(5));
    }
}
