package com.tlp.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @className: ThreadPoolExecutorDemo
 * @description: 线程池demo
 * @author: tianlingpeng
 * @create: 2019-04-27 09:53
 */
@Slf4j
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建固定容量大小的缓冲池
        ExecutorService executorService1 = Executors.newFixedThreadPool(10000);
        //创建容量为1的缓冲池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(6));
        for (int i = 0; i < 10000; i++) {
            MyTask myTask = new MyTask(i);
            executorService1.execute(myTask);
            System.out.println("线程池中线程的数目：" + executor.getPoolSize()
                    + ",队列中等待执行的任务数目：" + executor.getQueue().size() + ",已执行完成的任务数目：" + executor.getCompletedTaskCount());

        }
        executorService1.shutdown();

        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("延迟执行");
            }
        },3,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
       // System.out.println("正在执行的task " + taskNum);

        // System.out.println("正在执行的task " + Thread.currentThread().getName());
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完成");
        //System.out.println(Thread.currentThread().getName()+ ":执行完成");
    }

/*
     * Proceed in 3 steps:
     *
     * 1. If fewer than corePoolSize threads are running, try to
     * start a new thread with the given command as its first
     * task.  The call to addWorker atomically checks runState and
     * workerCount, and so prevents false alarms that would add
     * threads when it shouldn't, by returning false.
     *
     * 2. If a task can be successfully queued, then we still need
     * to double-check whether we should have added a thread
     * (because existing ones died since last checking) or that
     * the pool shut down since entry into this method. So we
     * recheck state and if necessary roll back the enqueuing if
     * stopped, or start a new thread if there are none.
     *
     * 3. If we cannot queue task, then we try to add a new
     * thread.  If it fails, we know we are shut down or saturated
     * and so reject the task.
*/
}
