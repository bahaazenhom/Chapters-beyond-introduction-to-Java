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
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];
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

    public static void parallelMergeSort(int[] arr) {
        RecursiveAction mainTask = new SortTask(arr);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

<<<<<<< HEAD
    private static  class SortTask extends RecursiveAction {
        private final int THRintSHOLD = 500;
=======
    private static class SortTask extends RecursiveAction {
        private final int THRESHOLD = 500;
>>>>>>> eefcd187873e5aa8ef3cbbccf1b8cd6ff8933360
        private int[] arr;

        SortTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        protected void compute() {
            if (arr.length < THRintSHOLD) Arrays.sort(arr);
            else {
                int[] firstHalf = new int[arr.length / 2];
                System.arraycopy(arr, 0, firstHalf, 0, arr.length / 2);
                int secondHalfLength = arr.length - arr.length / 2;
                int[] secondHalf = new int[secondHalfLength];
                System.arraycopy(arr, arr.length / 2, secondHalf, 0, secondHalfLength);
<<<<<<< HEAD
                SortTask task1=new SortTask((int[]) firstHalf);
                SortTask task2=new SortTask((int[])secondHalf);
=======
                SortTask task1 = new SortTask((int[]) firstHalf);
                SortTask task2 = new SortTask((int[]) secondHalf);
>>>>>>> eefcd187873e5aa8ef3cbbccf1b8cd6ff8933360

              /*  task1.fork();task2.fork();
                task1.join();task2.join();*/

                // task1.fork();task2.compute();// *in some cases* when we use this approach (forking the first task and compute the second directly)
                // it will increase the program performance comparing to using the regular approach
                // that happens because of it have less thread coordination overhead because it minimizes synchronization and waiting

                invokeAll(task1, task2);
                merge(firstHalf, secondHalf, temp);

            }
        }
    }

    public static void merge(int[] arr1, int[] arr2, Object[] temp) {
        int current1 = 0; // Current index in arr1
        int current2 = 0; // Current index in arr2
        int current3 = 0; // Current index in temp
        temp = new Object[arr1.length + arr2.length];
        while (current1 < arr1.length && current2 < arr2.length) {
<<<<<<< HEAD
            if ((arr1[current1])<(arr2[current2]))
=======
            if ((arr1[current1]) < (arr2[current2]))
>>>>>>> eefcd187873e5aa8ef3cbbccf1b8cd6ff8933360
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
