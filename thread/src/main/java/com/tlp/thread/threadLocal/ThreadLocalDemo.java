package com.tlp.thread.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className: ThreadLocalDemo
 * @description: 线程局部变量
 * @author: tianlingpeng
 * @create: 2019-04-27 14:47
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(3);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = new MyRefreshTask(1, threadLocal);
        Runnable task2 = new MyRefreshTask(2, threadLocal);
        executorService.execute(task1);
        executorService.execute(task2);
        System.out.println(Thread.currentThread().getName()+":  "+threadLocal.get());
        executorService.shutdown();
    }
}

class MyRefreshTask implements Runnable {
    private int num;

    private ThreadLocal<Integer> threadLocal = null;

    public MyRefreshTask(int num, ThreadLocal<Integer> threadLocal) {
        this.num = num;
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadLocal.set(num);
        System.out.println(Thread.currentThread().getName()+":  "+threadLocal.get());
    }
}
