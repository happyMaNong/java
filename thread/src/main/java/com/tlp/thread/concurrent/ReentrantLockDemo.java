package com.tlp.thread.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：tlp
 * @crateDate：2019/9/8 22:17
 */
@Slf4j
public class ReentrantLockDemo {

    //ReentrantLock相对于synchronized(jvm层面实现的，)
    //(1)可以指定公平锁和非公平锁
    //(2)提供Condition类，可以指定唤醒的线程
    //(3)可以中断线程

    public static int count;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        ExecutorService executors = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        MyRunnable myRunnable = new MyRunnable(lock, countDownLatch);
        for (int i = 0; i < 10; i++) {
            executors.execute(myRunnable);
        }

        countDownLatch.await();
        log.info("总和：{}", count);
        executors.shutdown();

    }

    static class MyRunnable implements Runnable {
        Lock lock = null;
        CountDownLatch countDownLatch = null;

        public MyRunnable(Lock lock, CountDownLatch countDownLatch) {
            this.lock = lock;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            lock.lock();
            Condition condition = lock.newCondition();
            try {
                for (int i1 = 0; i1 < 1000; i1++) {
                    count++;
                    if (count > 500&&count<510) {
                        log.info("{}",count);
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName()+"    "+count);
            }finally {
                countDownLatch.countDown();
                lock.unlock();
            }
        }
    }
}
