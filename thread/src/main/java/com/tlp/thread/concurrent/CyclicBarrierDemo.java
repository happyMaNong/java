package com.tlp.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @className: CyclicBarrierDemo
 * @description: 是一个可以循环使用的栅栏，它做的事情就是： 让线程到达栅栏时被阻塞(调用await方法)，直到到达栅栏的线程数满足指定数量要求时，栅栏才会打开放行
 * @author: tianlingpeng
 * @create: 2019-09-06 09:01
 */
public class CyclicBarrierDemo {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有运动员准备完毕");
            }
        });
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        Runnable myRunnable =cyclicBarrierDemo.new MyRunnable(cyclicBarrier);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(myRunnable,"运动员["+i+"]");
            thread.start();
        }

    }
    class MyRunnable implements Runnable{
        CyclicBarrier cyclicBarrier = null;
        public MyRunnable(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+":准备完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}


