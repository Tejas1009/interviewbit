package Demo;

public class MultiThreadingGDemo {
    private static final long SLEEP_INTERVAL = 3000;
    private boolean running = true;
    private Thread thread;

    public void start() {
        print("Inside start() method");
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                print("Inside run() method");
                try {
                    Thread.sleep(SLEEP_INTERVAL);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (MultiThreadingGDemo.this) {
                    running = false;
                    print("Before Notify");
                    MultiThreadingGDemo.this.notify();
                    print("After Notify");
                }
            }
        });
        thread.start();
    }

    public void join() throws InterruptedException {
        print("Inside join() method");
        synchronized (this) {
            while (running) {
                print("Waiting for the peer thread to finish.");
                wait(); //waiting, not running
                print("Tejas");
            }
            print("Peer thread finished.");
        }
    }

    private void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadingGDemo test = new MultiThreadingGDemo();
        test.start();
        test.join();
    }
}
