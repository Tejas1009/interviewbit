public class TestAbstractClasses {
    public static void main(String[] args) {
        B c = new B();
        c.display();
        C.BS b = new C.BS();
        b.m();
    }
}

interface i {
    int a = 0;
}

abstract class A implements i {
    int a = 1;

    protected abstract void display();
}

class B extends A {

    @Override
    protected void display() {
        a = 2;
        System.out.println(a);
    }
}

class C extends B {
    C() {
        this.a = 3;
    }

    public static class BS {

        public static void m() {
            System.out.println(
                    "Message from nested static class: ");
        }
    }
}