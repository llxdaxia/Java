package cn.alien95.io;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class lzwCode {

    private static int num = 0;

    static class MyThread implements Runnable {

        private int ticket = 3;  //5张票

        public void run() {
            for (int i = 0; i <= 100; i++) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "MyThread--正在卖票" + this.ticket--);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                tickets(30);
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                tickets(20);
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                tickets(10);
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                tickets(5);
            }
        });
        threadPool.execute(thread);
        threadPool.execute(thread);
        threadPool.execute(thread);
        threadPool.execute(thread);

    }

    public static void tickets(int ticket) {
        num ++;
        for (int i = 0; i <= 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "  " + num + "---正在卖票" + ticket--);
            }
        }
    }
}