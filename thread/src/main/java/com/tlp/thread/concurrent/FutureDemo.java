package com.tlp.thread.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @className: FutureDemo
 * @description: Future表示一个可能还没有完成的异步任务的结果，针对这个结果可以添加Callback以便在任务执行成功或失败后作出相应的操作。
 * @author: tianlingpeng
 * @create: 2019-09-06 11:49
 */
public class FutureDemo {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("计算线程正在执行");
                Thread.sleep(3000);
                return 500;
            }
        };
//        FutureTask future = new FutureTask(callable);
//        Thread thread = new Thread(future);
//        thread.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(callable);
        try {
            System.out.println("主线程正在执行");
            Thread.sleep(10000);
            int i = future.get();
            System.out.println("程序执行完毕，计算结果：" + i);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
