package com.tlp.thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @className: ThreadPoolExecutorDemo
 * @description: 线程池demo
 * @author: tianlingpeng
 * @create: 2019-04-27 09:53
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建固定容量大小的缓冲池
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        //创建容量为1的缓冲池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

     ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(6));
        for (int i = 0; i < 16; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程的数目：" + executor.getPoolSize()
                    + ",队列中等待执行的任务数目：" + executor.getQueue().size() + ",已执行完成的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
      System.out.println("正在执行的task " + taskNum);

       // System.out.println("正在执行的task " + Thread.currentThread().getName());
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       System.out.println("task " + taskNum + "执行完成");
        //System.out.println(Thread.currentThread().getName()+ ":执行完成");
    }
}