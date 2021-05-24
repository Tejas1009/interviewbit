package Demo;

public class Vehicle implements Engine {
    @Override
    public void start() {
        System.out.println("From Vehicle");
    }
}
