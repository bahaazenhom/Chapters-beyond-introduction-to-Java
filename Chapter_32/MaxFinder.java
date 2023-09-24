package Chapter_32;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class MaxFinder extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 5; // Threshold for splitting the task
    private final int[] array;
    private final int start;
    private final int end;

    public MaxFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int length = end - start + 1;

        if (length <= THRESHOLD) {
            // If the array is small enough, find the maximum sequentially.
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, array[i]);
            }
            return max;
        } else {
            // Split the task into two subtasks.
            int middle = start + (end - start) / 2;
            MaxFinder leftTask = new MaxFinder(array, start, middle);
            MaxFinder rightTask = new MaxFinder(array, middle + 1, end);

            // Fork the left subtask and compute the right subtask.
            leftTask.fork();
            int rightMax = rightTask.compute();

            // Join the left subtask and find the maximum of the two results.
            int leftMax = leftTask.join();

            return Math.max(leftMax, rightMax);
        }
    }

    public static void main(String[] args) {
        final int N = 900000000;
        int[] list = new int[N]; // Sample array
        for (int i = 0; i < list.length; i++) list[i] = i;
        ForkJoinPool pool = new ForkJoinPool();
        MaxFinder task = new MaxFinder(list, 0, list.length - 1);
        long startTime = System.currentTimeMillis();
        int result = pool.invoke(task);
        System.out.println("\nThe maximal number is " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("The number of processors is " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time is " + (endTime - startTime) + " milliseconds");
    }
}
