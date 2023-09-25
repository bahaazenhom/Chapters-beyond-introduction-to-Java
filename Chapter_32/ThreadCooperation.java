package Chapter_32;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    public static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();
    }

    private static class DepositTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    account.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class WithdrawTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    account.withdraw((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class Account {
        private static Lock lock = new ReentrantLock();// Here we are using Reentrant Locking to control our threads.
        private static Condition condition = lock.newCondition();// we created a new condition to control the threads.
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();// we here give the current thread the lock
            try {
                balance += amount;
                System.out.println("Deposit " + amount + " to the balance, new balance is " + account.getBalance());
                condition.signalAll();// we signals all the waiting thread to be continued
            } finally {
                lock.unlock();// here we release the lock from the thread and allow others to use it
            }
        }

        public void withdraw(int amount) throws InterruptedException {
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("awaiting for a new amount to be deposited");
                    condition.await();// here we release the lock for another thread to take and wait for a signal to continue
                }
                balance -= amount;
                System.out.println("-----amount " + amount + " is withdraw, the new balance is " + account.getBalance() + "------\n");
            } finally {
                lock.unlock();
            }
        }

    }
}
