package Chapter_32;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadDemo {
    public static void main(String[] argus) throws IOException, InterruptedException {
        PrintChar task1 = new PrintChar('a', 10), task2 = new PrintChar('b', 10);// we here create a task to be performed by a thread,

        Thread thread1 = new Thread(task1);// to assign a task to a thread
        Thread thread2 = new Thread(task2);

        thread1.setPriority(Thread.MAX_PRIORITY);// this how we set the priority for a specific thread.

        thread2.start();// to start a specific thread.
        thread1.start();

        new Thread(() -> System.out.println("hi")).start();// creating and starting a new thread using lambda expression.


    }

    static class PrintChar implements Runnable {// the class has to implement the interface Runnable and we have to override the method run().
        char c;
        int numberOfTimes;

        public PrintChar(char c, int numberOfTimes) {
            this.c = c;
            this.numberOfTimes = numberOfTimes;
        }

        @Override
        public void run() {
            for (int i = 0; i < numberOfTimes; i++) {
                System.out.print(c + " ");

            }
        }

    }
}
