package Siemens;

@FunctionalInterface
interface i1 {
    int getInput(int num1);

    default int getVal() {
        return 0;
    }
}

public class Hacker {

    int hack_method(int h1, int h2) {
        return h1 + h2;
    }

    int hack_method(int h1, int h2, int h3) {
        return h1 + h2 + h3;
    }

    void hack_opr() {
        System.out.println(hack_method(10, 10));
    }

    public static void main(String[] args) {
        new Hacker().hack_opr();
    }
}
