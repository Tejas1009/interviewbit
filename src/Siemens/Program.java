package Siemens;

abstract class MyClass {
    private void disp1() {
        System.out.println("Parent class");
    }

    abstract public void disp2();

    abstract void disp3();

    abstract protected void disp4();
}

public class Program extends MyClass {
    @Override
    public void disp2() {
        System.out.println("1");
    }

    @Override
    void disp3() {
        System.out.println("2");
    }

    @Override
    protected void disp4() {
        System.out.println("3");
    }

    public static void main(String[] args) {
        Program p = new Program();
    }
}
