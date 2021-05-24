package Demo;

public class MethodReferenceTest {
    public static void main(String[] args) {
        Engine e = new Vehicle();
        e.start();
        
        Engine e1 = () -> System.out.println("Custom");
        e1.start();
    }
}
