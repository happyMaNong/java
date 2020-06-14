package com.tlp.thread.producerconsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @className: Demo
 * @description:生产消费模式
 * @author: tianlingpeng
 * @create: 2019-10-23 15:41
 */
@Slf4j
public class Demo {
    public static int count = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor producerPool = new ThreadPoolExecutor(
                2,
                2,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(6),
                new ThreadFactory() {
                    int i = 1;

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("生产线程" + i++);
                        return thread;
                    }
                });

        ThreadPoolExecutor consumerPool = new ThreadPoolExecutor(
                2,
                2,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(6),
                new ThreadFactory() {
                    int i = 1;

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("消费线程" + i++);
                        return thread;
                    }
                });

//        ExecutorService producerPool = Executors.newFixedThreadPool(5);
//        ExecutorService consumerPool = Executors.newFixedThreadPool(5);

        Object o1 = new Object();
        //Object o2 = new Object();
        for (int i = 0; i < 2; i++) {
            consumerPool.execute(() -> {
                synchronized (o1) {
                    while (count <= 0) {
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("{}", count);
                    o1.notifyAll();
                }
            });

            producerPool.execute(() -> {
                synchronized (o1) {
                    while (count > 0) {
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("{}", count);
                    o1.notifyAll();
                }
            });

        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producerPool.shutdown();
        consumerPool.shutdown();
    }
}
