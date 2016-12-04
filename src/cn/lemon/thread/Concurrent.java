package cn.alien95.thread;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by linlongxin on 2016/4/4.
 */
public class Concurrent {

    private static String a= "静态成员";
    private String b = "非静态成员";

    public static void main(String[] args) {
        Concurrent concurrent = new Concurrent();
        HashMap hashMap = new HashMap();
        hashMap = new HashMap(30);
        LinkedBlockingDeque queue;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100; j++) {
                    System.out.println(Thread.currentThread().getName() + "   " + j);
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }

}
