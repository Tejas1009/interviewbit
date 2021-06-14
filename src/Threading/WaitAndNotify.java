package Threading;

import java.util.Scanner;

public class WaitAndNotify {
    public static void main(String[] args) {
        PC p = new PC();
        Thread t1 = new Thread(() -> {
            try {
                p.produces();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                p.consumes();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}

class PC {
    public void produces() throws InterruptedException {
        synchronized (this) {
            System.out.println("Inside Produces");
            wait();
            System.out.println("Done Producing");
        }
    }

    public void consumes() throws InterruptedException {
        synchronized (this) {
            System.out.println("Inside Consumes");
            Scanner sc = new Scanner(System.in);
            sc.next();
            Thread.sleep(2000);
            notify();
            System.out.println("Done Consuming");
        }
    }
}