package TwoPointer;

public class Test {
    public static int fact(int x) {
        if (x == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        return x * fact(x - 1);
    }

    public static int fib(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        return fib(x - 1) + fib(x - 2);
    }

    public static void powerSet(int arr[], int n, String osf) {
        if (n == osf.length()) {
            System.out.println(osf);
            return;
        }
        powerSet(arr, n + 1, osf + arr[n]);
        powerSet(arr, n + 1, osf);
    }

    public static void main(String[] args) {
        int x = 8;
        //System.out.println(fact(x));
        //System.out.println(fib(x));
        int arr[] = {1, 2, 3};
        powerSet(arr, 0, "");
    }
}
