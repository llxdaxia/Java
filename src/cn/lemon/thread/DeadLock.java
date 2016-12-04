package cn.alien95.thread;

/**
 * Created by linlongxin on 2016/4/4.
 */
public class DeadLock {

    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                firstMethod();
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                seconedMethod();
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();

    }

    public static void firstMethod(){
        synchronized (a){
            System.out.println(Thread.currentThread().getName() + "  firstMethod--死锁");
            try {
//                Thread.sleep(10);
                a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + "  firstMethod--解锁");
            }
        }
    }

    public static void seconedMethod(){
        synchronized (b){
            System.out.println(Thread.currentThread().getName() + "  seconedMethod--死锁");
            synchronized (a){
                System.out.println(Thread.currentThread().getName() + "  seconedMethod--解锁");
                a.notify();
            }
        }
    }
}
