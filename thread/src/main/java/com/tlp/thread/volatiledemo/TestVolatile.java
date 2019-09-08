package com.tlp.thread.volatiledemo;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @className: TestVolatile
 * @description: 测试volatile变量
 * @author: tianlingpeng
 * @create: 2019-09-05 14:15
 */
@Slf4j
public class TestVolatile {


    //不能保证线程安全，因为对int的操作不一定是原子性的
   public static volatile int count;

    //线程安全的 CAS compareAndSet
    // public static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executors = Executors.newCachedThreadPool();
        MyRunnable myRunnable = new MyRunnable(countDownLatch);
        for (int i = 0; i < 10; i++) {
            executors.execute(myRunnable);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executors.shutdown();
        log.info("总数：,{}",count);
        System.out.println(count);
    }

    static class MyRunnable implements Runnable {
        public CountDownLatch countDownLatch = null;

        public MyRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            for (int i1 = 0; i1 < 1000; i1++) {
                synchronized (this) {
                    count++;
                }
               // count.incrementAndGet();
            }
            countDownLatch.countDown();
        }
    }

}



