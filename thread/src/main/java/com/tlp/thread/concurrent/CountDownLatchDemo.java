package com.tlp.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @className: CountDownLatchDemo
 * @description: 用CountDownLatch : 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行
 * @author: tianlingpeng
 * @create: 2019-04-27 09:19
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Thread thread1 = new MyThread("A", latch);
        Thread thread2 = new MyThread("B", latch);
        Thread thread3 = new MyThread("C", latch);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            latch.await();//等待线程全部结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全部完成");

    }

    static class MyThread extends Thread {
        private String name = "";

        private CountDownLatch latch = null;

        public MyThread(String name, CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":已完成");
            latch.countDown();
        }
    }
}
