package Others;

class P {
    protected void print() {
        System.out.println("Hello");
    }
}

class Q extends P {

}

class R extends Q {

    @Override
    protected void print() {
        System.out.println("R-Hello");
    }

    public void xyz() {
        this.print();
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        R r = new R();
        r.print();
    }
}