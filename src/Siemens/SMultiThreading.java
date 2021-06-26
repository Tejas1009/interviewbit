package Siemens;

public class SMultiThreading extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("hello");
            }
            System.out.println(i + " ");
        }
    }

    public static void main(String[] args) {
        SMultiThreading h1 = new SMultiThreading();
        SMultiThreading h2 = new SMultiThreading();
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        try {
            h1.join();
        } catch (Exception e) {
            System.out.println("hi");
        }
        h2.start();
    }
}
