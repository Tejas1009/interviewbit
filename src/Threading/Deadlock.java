package Threading;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        String s1 = "resource1";
        String s2 = "resource2";
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    System.out.println("T1 running acquired s1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    synchronized (s2) {
                        System.out.println("T1 running acquired s2");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (s2) {
                    System.out.println("T2 running acquired s2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    synchronized (s1) {
                        System.out.println("T2 running acquired s1");
                    }
                }
            }
        };
        t1.start();
        t1.join();
        t2.start();
    }
}
