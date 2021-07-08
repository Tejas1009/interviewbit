package Others.Recursion;

public class PrintZigZag {

    public static void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Pre: " + n);
        print(n - 1);
        System.out.println("In: " + n);
        print(n - 1);
        System.out.println("Post: " + n);
    }

    public static void main(String[] args) {
        print(2);
        //321123
        //3211121112321112111123
    }
}
