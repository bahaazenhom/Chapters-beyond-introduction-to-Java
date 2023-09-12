package Chapter_32.Exercises;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelArrayInitializer {
    public static void main(String[] args){
        int[] arr = new int[90000000];
        long start=System.currentTimeMillis();
        ParallelInitializer(arr);
        long end=System.currentTimeMillis();
        System.out.println("Total time taken to initialize in parallel: "+(end-start));
        arr=new int[90000000];
        start=System.currentTimeMillis();
        for(int i=0;i<arr.length;i++)arr[i]=i;
        end=System.currentTimeMillis();
        System.out.println("Total time taken to initialize sequentially: "+(end-start));
    }
    static void ParallelInitializer(int[] arr){
        Intialize intialize=new Intialize(arr,0,arr.length);
        ForkJoinPool pool=new ForkJoinPool();
        pool.invoke(intialize);

    }
    static class Intialize extends RecursiveAction {
        int[] arr;
        private final int THRESHOLD = 500;
        int low,high;
        public Intialize(int[] arr,int low,int high) {
            this.arr=arr;
            this.low=low;
            this.high=high;
        }

        @Override
        protected void compute() {
            if(high-low<=THRESHOLD){
                for(int i=low;i<high;i++)arr[i]=i;
            }
            else{
                int mid=(high+low)/2;
                Intialize task1=new Intialize(arr,low,mid),task2=new Intialize(arr,mid,high);
                task1.fork();task2.fork();
                task1.join();task2.join();
            }
        }
    }
}
