package com.tlp.thread.test;

/**
 * @author：tlp
 * @crateDate：2019/9/29 21:24
 */
public class PrintABC {
    public static void main(String[] args) throws InterruptedException {
        PrintRunnable runnable1 = new PrintRunnable("c","a");
        PrintRunnable runnable2 = new PrintRunnable("a","b");
        PrintRunnable runnable3 = new PrintRunnable("b","c");
        Thread thread1 = new Thread(runnable1);
        Thread thread2= new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        thread1.start();
        Thread.sleep(10);
        thread2.start();
        Thread.sleep(10);
        thread3.start();
    }
}
class PrintRunnable implements Runnable{
    Object pre,cru;

    public PrintRunnable(Object pre, Object cru) {
        this.pre = pre;
        this.cru = cru;
    }

    @Override
    public void run() {
        int count=10;
        while (count>0) {
            synchronized (pre) {
                synchronized (cru) {
                    System.out.println(cru);
                    count--;
                    cru.notifyAll();
                }
                if (count==0){
                    pre.notifyAll();
                }else {
                    try {
                        pre.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
