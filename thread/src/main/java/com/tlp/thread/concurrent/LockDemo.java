package com.tlp.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @className: LockDemo
 * @description:
 * @author: tianlingpeng
 * @create: 2019-10-11 09:42
 */
public class LockDemo {
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(2, new ThreadFactory() {
            int count = 0;
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("线程" + count++);
                return thread;
            }
        });

        TaskRunnable taskRunnable = new TaskRunnable();
        threadPool.execute(taskRunnable);
        threadPool.execute(taskRunnable);
        threadPool.shutdown();

    }

    static class TaskRunnable implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":正在执行任务");
        }
    }
}
