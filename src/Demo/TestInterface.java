package Demo;

interface i1 {
    void display();
}

interface i2 {
    void display();
}

class TestInterface implements i1, i2 {

    public static void main(String[] args) {
        TestInterface t = new TestInterface2();
        t.display();
    }

    @Override
    public void display() {
        System.out.println("From Base");
    }
}

class TestInterface2 extends TestInterface implements i1, i2 {

    @Override
    public void display() {
        System.out.println("From Child");
    }
}