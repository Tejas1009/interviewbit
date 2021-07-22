package Others;

class AXB {
    public void m1(long x) {
        System.out.println("Long");
    }

    public void m1(Integer x) {
        System.out.println("Integer");
    }

    public void m1(float x) {
        System.out.println("Float");
    }

    public void m1(double x) {
        System.out.println("Double");
    }

    public void m1(String x) {
        System.out.println("Integer");
    }

    public void test(int i, int j, int k) {
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}

public class MethodOverloadingTest {
    public static void main(String[] args) {
        AXB a = new AXB();
        a.m1(1.1f);
        int i = 10;
        a.test(i++, i++, i++);
    }
}