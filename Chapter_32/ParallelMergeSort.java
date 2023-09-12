package Chapter_32;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort {
    public static Object[] temp;

    public static void main(String[] args) {
        final int SIZE = 7000000;
        Integer[] list1 = new Integer[SIZE];
        Integer[] list2 = new Integer[SIZE];
        for (int i = 0; i < list1.length; i++)
            list1[i] = list2[i] = (int) (Math.random() * 10000000);

        long startTime = System.currentTimeMillis();
        parallelMergeSort(list1); // Invoke parallel merge sort
        long endTime = System.currentTimeMillis();

        System.out.println("\nParallel time with "
                + Runtime.getRuntime().availableProcessors() +
                " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        Arrays.sort(list2);
        endTime = System.currentTimeMillis();

        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
    }

    public static <E extends Comparable<E>> void parallelMergeSort(E[] arr) {
        RecursiveAction mainTask = new SortTask(arr);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static  class SortTask<E extends Comparable<E>> extends RecursiveAction {
        private final int THRESHOLD = 500;
        private E[] arr;

        SortTask(E[] arr) {
            this.arr = arr;
        }

        @Override
        protected void compute() {
            if (arr.length < THRESHOLD) Arrays.sort(arr);
            else {
                E[] firstHalf = (E[]) new Object[arr.length / 2];
                System.arraycopy(arr, 0, firstHalf, 0, arr.length / 2);
                int secondHalfLength = arr.length - arr.length / 2;
                E[] secondHalf = (E[]) new Object[secondHalfLength];
                System.arraycopy(arr, arr.length / 2, secondHalf, 0, secondHalfLength);
                SortTask task1=new SortTask((E[]) firstHalf);
                SortTask task2=new SortTask((E[])secondHalf);

              /*  task1.fork();task2.fork();
                task1.join();task2.join();*/

               // task1.fork();task2.compute();// *in some cases* when we use this approach (forking the first task and compute the second directly)
                // it will increase the program performance comparing to using the regular approach
                // that happens because of it have less thread coordination overhead because it minimizes synchronization and waiting

                invokeAll(task1,task2);
                merge(firstHalf, secondHalf  , temp);

            }
        }
    }

    public static <E extends Comparable<E>> void merge(E[] arr1, E[] arr2, Object[] temp) {
        int current1 = 0; // Current index in arr1
        int current2 = 0; // Current index in arr2
        int current3 = 0; // Current index in temp
        temp = new Object[arr1.length + arr2.length];
        while (current1 < arr1.length && current2 < arr2.length) {
            if ((arr1[current1]).compareTo(arr2[current2])<0)
                temp[current3++] = arr1[current1++];
            else
                temp[current3++] = arr2[current2++];
        }

        while (current1 < arr1.length)
            temp[current3++] = arr1[current1++];

        while (current2 < arr2.length)
            temp[current3++] = arr2[current2++];
    }
}
