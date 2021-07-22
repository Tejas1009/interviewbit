package Others;

class ABCZ {
    public void a() {
        try {
            b();
        } catch (Exception e) {
            System.out.println("Caught Exception by a()");
        } finally {
            System.out.println("In Finaly a()");
        }
    }

    public void b() {
        try {
            c();
        } catch (Exception e) {
            System.out.println("Caught Exception by b()");
        } finally {
            System.out.println("In Finaly b()");
        }
    }

    public void c() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Caught Exception by c()");
        } finally {
            System.out.println("In Finally c()");
        }
    }
}

public class TestException {
    public static void main(String[] args) {
        ABCZ a = new ABCZ();
        a.a();
        Integer a1 = 1;
        Integer b1 = 1;
        System.out.println(a1 == b1);
    }
}
