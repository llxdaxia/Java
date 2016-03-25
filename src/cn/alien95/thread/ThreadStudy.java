package cn.alien95.thread;


import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by llxal on 2015/11/24.
 */
public class ThreadStudy {

    private static OneThread oneThread;
    private static TwoThread twoThread;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        oneThread = new ThreadStudy().new OneThread();  //new的第一次用的线程是main线程，前台线程
        twoThread = new ThreadStudy().new TwoThread();
        oneThread.start();

    }

    static class ThreadHolder{
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            Random random = new Random(41);
            @Override
            protected Integer initialValue() {
                return random.nextInt(100);
            }
        };

        public static void increment(){
            threadLocal.set(threadLocal.get());   //获取一个Integer对象，就是上面initialValue()实现化并且返回的，源码写了
        }

        public static int get(){
            return threadLocal.get();
        }
    }

    class OneThread extends Thread{

        public OneThread(){
            System.out.println(Thread.currentThread().getName());
            try {
                TwoThread twoThread = new TwoThread();
                twoThread.start();
                twoThread.join();  //不是应该执行完了才执行onwThread么
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void run() {
            super.run();
            System.out.println("one");
        }
    }

    class TwoThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println(Thread.currentThread().getName());
            System.out.println("two");
        }
    }
}
