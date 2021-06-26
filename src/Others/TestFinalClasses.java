package Others;

final class ABC {
    public final int i = 0;

    public int getA() {
        return i;
    }
}

public class TestFinalClasses {

    public static void main(String[] args) {
        ABC a = new ABC();
        ABC b = new ABC();
        a = b;
        System.out.println(a.i);
        System.out.println(b.i);
    }
}
