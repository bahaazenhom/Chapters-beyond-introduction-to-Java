package Chapter_32;

import java.io.IOException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// we used locks and conditions to synchronize the Producer and Consumer
// threads. This program does not use locks and conditions because synchronization is already
// implemented in ArrayBlockingQueue.
public class ConsumerProducerUsingBlockingQueue {
    public static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2);

    public static void main(String[] argus) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new ConsumerTask());
        executorService.execute(new ProducerTask());
        executorService.shutdown();// we have to shut down the executor after finish ( in that case the pool can't accept new tasks ).

    }

    private static class ProducerTask implements Runnable {

        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes " + i);
                    buffer.put(i++);
                    Thread.sleep((int) (Math.random() * 10000));// here we give a chance for the other thread to arbitrary run many times just to test our code.
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class ConsumerTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Consumer reads " + buffer.take() + "\n");
                    Thread.sleep((int) (Math.random() * 10000));// here we give a chance for the other thread to arbitrary run many times just to test our code.
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
