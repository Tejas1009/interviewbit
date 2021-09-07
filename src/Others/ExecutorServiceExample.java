package Others;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    static class Worker implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        executorService.shutdown();
    }
}
