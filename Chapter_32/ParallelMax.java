package Chapter_32;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMax {
    public static void main(String[] args) {
        final int N = 900000000;
        int[] list = new int[N];
        for (int i = 0; i < list.length; i++) list[i] = i;

        long startTime = System.currentTimeMillis();
        System.out.println("\nThe maximal number is " + maxParallel(list));
        long endTime = System.currentTimeMillis();
        System.out.println("The number of processors is " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time is " + (endTime - startTime) + " milliseconds");
    }


    public static int maxParallel(int[] arr) {
        RecursiveTask<Integer> task = new MaxTask(arr, 0, arr.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class MaxTask extends RecursiveTask<Integer> {
        private final static int THRESHOLD = 5;
        private int left;
        private int right;
        private int[] arr;

        MaxTask(int[] arr, int left, int rigth) {
            this.arr = arr;
            this.left = left;
            this.right = rigth;
        }

        @Override
        protected Integer compute() {
            if (right - left <= THRESHOLD) {
                int max = arr[0];
                for (int i = left; i < right; i++) if (arr[i] > max) max = arr[i];
                return max;
            } else {
                int mid = (right + left) / 2;
                MaxTask task1 = new MaxTask(arr, left, mid);
                MaxTask task2 = new MaxTask(arr, mid, right);
                task1.fork();task2.fork();
                int r=task2.join();
                int l= task1.join();
                return Math.max(r,l);
            }
        }
    }
}
