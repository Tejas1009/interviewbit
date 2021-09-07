package Others;

import java.util.concurrent.*;

public class CallableFuture {

    static class Worker implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 2;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(new Worker());
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}