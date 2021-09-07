package Others;

public class EvenOddUsingTwoThreadsJava {

    int counter;
    int n;

    public EvenOddUsingTwoThreadsJava(int counter, int n) {
        this.counter = counter;
        this.n = n;
    }

    public void printOddNumber() throws InterruptedException {
        synchronized (this) {
            while (counter < n) {
                if (counter % 2 == 0) {
                    wait();
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }

    // Function to print even numbers
    public void printEvenNumber() throws InterruptedException {
        synchronized (this) {
            while (counter < n) {
                if (counter % 2 == 1) {
                    wait();
                }
                System.out.print(
                        counter + " ");
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddUsingTwoThreadsJava e = new EvenOddUsingTwoThreadsJava(1, 10);
        Thread t1 = new Thread(() -> {
            try {
                e.printEvenNumber();
            } catch (Exception e1) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                e.printOddNumber();
            } catch (Exception e2) {

            }
        });
        t1.start();
        t2.start();
    }
}
