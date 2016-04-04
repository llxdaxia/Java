package cn.alien95.thread;

/**
 * Created by llxal on 2015/11/25.
 */
public class ThreadLock {

    Object lock = new Object();
    int num = 0;

    public static void main(String[] args) {

        ThreadLock test = new ThreadLock();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
        test.method1();
    }

    public void method1(){
        synchronized (lock){
            try {
                Thread.sleep(1000);
//                lock.wait(1000);
                num += 100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void method2(){
        synchronized (lock){
            num += 9;
            System.out.println(num);
        }
    }

}
