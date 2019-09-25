package com.tlp.thread.volatiledemo;

/**
 * @className: VolatileDemo
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-19 13:45
 */
public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        TaskRunnbale taskRunnbale = new TaskRunnbale();
        Thread thread = new Thread(taskRunnbale);
        thread.start();
        Thread.sleep(5000);
        taskRunnbale.flag =true;
    }
}

class TaskRunnbale implements Runnable {
     boolean flag = false;

    int i = 0;

    @Override
    public void run() {
        while (!flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(i);
            if (flag)
            return;
        }

    }
}