package Others;

import java.io.IOException;

interface i11 {

}

class X implements i11 {

}

class Y extends X {

}

class A {

    public X add() throws StackOverflowError {
        X x = new X();
        return x;
    }
}

public class TestInheritanceException extends A {

    public Y add() throws Error {
        Y x = new Y();
        return x;
    }

    public static void main(String[] args) {
        TestInheritanceException f = new TestInheritanceException();
        f.add();
    }
}