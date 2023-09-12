package Chapter_32.Exercises;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSum {
    public static void main(String[] args){
        double[] arr = (new Random()).doubles(100000000,1,2).toArray();
        long start=System.currentTimeMillis();
        double sum = parallelSum(arr);
        long end=System.currentTimeMillis();
        System.out.println("Total time taken to sum the array in parallel: "+(end-start)+" and the sum is "+sum);
        start=System.currentTimeMillis();
        sum = 0;
        for (double v : arr) sum += v;
        end=System.currentTimeMillis();
        System.out.println("Total time taken to sum the array sequentially: "+(end-start)+" and the sum is "+sum);

    }
    public static double parallelSum(double[] arr){
        Intialize intialize=new Intialize(arr,0,arr.length);
        ForkJoinPool pool=new ForkJoinPool();
        return pool.invoke(intialize);
    }
    static class Intialize extends RecursiveTask<Double> {
        double[] arr;
        private int THRESHOLD = 100;
        int low,high;
        public Intialize(double[] arr,int low,int high) {
            this.arr=arr;
            this.low=low;
            this.high=high;
        }

        @Override
        protected Double compute() {
            if(high-low<=THRESHOLD){
                double sum=0;
                for(int i=low;i<high;i++)sum+=arr[i];
                return sum;
            }
            else{
                int mid=(high+low)/2;
                Intialize task1=new Intialize(arr,low,mid),task2=new Intialize(arr,mid,high);
                task1.fork();task2.fork();
                return (task1.join()+task2.join());
            }
        }
    }
}

