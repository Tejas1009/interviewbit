package Others;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private final BlockingQueue<Runnable> workerQueue;
    private final Thread[] workerThreads;

    public CustomThreadPool(int n) {
        this.workerQueue = new LinkedBlockingQueue<>();
        this.workerThreads = new Thread[n];
        for (int i = 0; i < n; i++) {
            this.workerThreads[i] = new WorkerThread();
            this.workerThreads[i].start();
        }
    }

    public void addTask(Runnable task) {
        workerQueue.add(task);
    }

    class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    workerQueue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPool ctp = new CustomThreadPool(5);
        ctp.addTask(() -> {
            System.out.println("Hi");
        });
        ctp.addTask(() -> {
            System.out.println("Hello");
        });
    }
}
