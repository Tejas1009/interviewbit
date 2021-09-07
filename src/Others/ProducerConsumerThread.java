package Others;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerThread {
    List<Integer> list;
    int capacity;

    private ProducerConsumerThread() {
        list = new LinkedList<>();
        capacity = 2;
    }

    public void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            synchronized (this) {
                if (list.size() >= capacity) {
                    wait();
                }
                list.add(val++);
                notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (list.size() <= 0) {
                    wait();
                }
                System.out.println(list.remove(0));
                notify();
                Thread.sleep(1000);
            }
        }
    }


    public static void main(String[] args) {
        ProducerConsumerThread pt = new ProducerConsumerThread();
        Thread t1 = new Thread(() -> {
            try {
                pt.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                pt.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
