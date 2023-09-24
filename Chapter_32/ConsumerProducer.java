package Chapter_32;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// --- Introduction to java's beyond chapters | Chapter 32: Multithreading and Parallel Programming P.1291 ---

public class ConsumerProducer {
    private static final Buffer buffer=new Buffer();

    public static void main(String[] argus) throws IOException, InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        executorService.execute(new ConsumerTask());
        executorService.execute(new ProducerTask());
        executorService.shutdown();// we have to shut down the executor after finish ( in that case the pool can't accept new tasks ).

    }
    private static class ProducerTask implements Runnable{

        @Override
        public void run() {
            try {
                int i=1;
                while(true){
                    System.out.println("Producer writes "+i);
                    buffer.write(i++);
                    Thread.sleep((int)(Math.random() * 10000));// here we give a chance for the other thread to arbitrary run many times just to test our code.
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static class ConsumerTask implements Runnable{

        @Override
        public void run() {
            try {
                while(true){
                    System.out.println("Consumer reads "+buffer.read()+"\n");
                    Thread.sleep((int)(Math.random() * 10000));// here we give a chance for the other thread to arbitrary run many times just to test our code.
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static class Buffer {
        private static final int capacity = 1;
        private final Queue<Integer> queue=new ArrayDeque<>();
        private static final Lock lock=new ReentrantLock();
        private static final Condition notEmpty=lock.newCondition();
        private static final Condition notFull=lock.newCondition();
        public int getCapacity(){
            return queue.size();
        }
        public void write(int value){
            lock.lock();
            try {
                while(queue.size()>=capacity){
                    System.out.println("wait for notFull condition");
                    notFull.await();// here we give a chance for the read thread to be executed and for a signal from it to continue.
                }
                queue.offer(value);
                notEmpty.signal();// this is the signal that the notEmpty in the method "read" is waiting for.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
            }
        }
        public int read() throws InterruptedException {
            int value=-1;
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("wait for notEmpty condition");
                    notEmpty.await();// here we give a chance for the write method to run and wait for a signal from it to continue.
                }
                value = queue.poll();
                notFull.signal();// this is the signal that the notFull in the method "write" is waiting for.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
                return value;
            }
        }
    }
}


