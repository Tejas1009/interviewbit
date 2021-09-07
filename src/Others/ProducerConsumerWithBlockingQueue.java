package Others;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWithBlockingQueue {
    static Integer i = 0;

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        final Thread producer = new Thread(() -> {
            try {
                while (true) {
                    blockingQueue.put(i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        final Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(blockingQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
    }
}
