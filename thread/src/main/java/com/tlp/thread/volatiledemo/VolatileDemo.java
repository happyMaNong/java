package com.tlp.thread.volatiledemo;

/**
 * @className: VolatileDemo
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-19 13:45
 */
public class VolatileDemo {
     //static boolean flag =false;
   volatile static boolean flag =false;
    public static void main(String[] args) throws InterruptedException {
        TaskRunnbale taskRunnbale = new TaskRunnbale();
        Thread thread = new Thread(taskRunnbale);

        TaskRunnbaleB taskRunnbaleB = new TaskRunnbaleB();
        Thread threadB = new Thread(taskRunnbaleB);

        thread.start();

        Thread.sleep(1000);
       // threadB.start();

      flag =true;
    }
    static class TaskRunnbale implements Runnable {
        @Override
        public void run() {
            while (true){
                if (flag) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("正在执行代码");
                }
            }
        }
    }


    static class TaskRunnbaleB implements Runnable {
        @Override
        public void run() {
            flag = true;
            System.out.println(Thread.currentThread().getName() + " : flag is " + flag);
        }
    }

}
