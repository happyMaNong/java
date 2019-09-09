package com.tlp.thread.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @className: ForkJoinDemo
 * @description: Fork/Join框架的基本思想就是将一个大任务分解（Fork）成一系列子任务，子任务可以继续往下分解，当多个不同的子任务都执行完成后，可以将它们各自的结果合并（Join）成一个大结果，最终合并成大任务的结果：
 * @author: tianlingpeng
 * @create: 2019-09-06 13:50
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
      int[] arr =  new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        ArrayCalculateTask task = new ArrayCalculateTask(arr,0,9999);

        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(task);

        if (forkJoinTask.isCompletedAbnormally()) {
            System.out.println(forkJoinTask.getException());
        }

        try {
            System.out.println("result:"+forkJoinTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class ArrayCalculateTask extends RecursiveTask<Long> {
        private final int[] arr;

        private final int begin;

        private final int end;

        private static final int THRESHOLD = 100;

        public ArrayCalculateTask(int[] arr, int begin, int end) {
            this.arr = arr;
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            if (end - begin + 1 < THRESHOLD) {
                for (int i = begin; i <= end; i++) {
                    sum += arr[i];
                }
            } else {
                int middle = (end + begin) / 2;
                ArrayCalculateTask arrayCalculateTask1 = new ArrayCalculateTask(this.arr, begin, middle);
                ArrayCalculateTask arrayCalculateTask2 = new ArrayCalculateTask(this.arr, middle + 1, end);
                arrayCalculateTask1.fork();
                arrayCalculateTask2.fork();
                long sum1 = arrayCalculateTask1.join();
                long sum2 = arrayCalculateTask2.join();
                System.out.println("------------");
                System.out.println(sum1+sum2);
                sum = sum1+sum2;
            }
            return sum;
        }
    }
}
