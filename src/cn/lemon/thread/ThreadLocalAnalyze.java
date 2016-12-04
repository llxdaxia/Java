package cn.alien95.thread;


import java.util.concurrent.ExecutionException;

/**
 * Created by llxal on 2015/11/24.
 */
public class ThreadLocalAnalyze {

    private static OneThread oneThread;
    private static TwoThread twoThread;
    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 99;
        }
    };
    private static ThreadLocal<String> stringThreadLocal = new InheritableThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "Hello world";
        }
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        oneThread = new ThreadLocalAnalyze().new OneThread();
        twoThread = new ThreadLocalAnalyze().new TwoThread();
        oneThread.start();
        twoThread.start();

    }

    class OneThread extends Thread{

        public OneThread(){
        }

        @Override
        public void run() {
            //给Thread的threadLocals变量赋值，并把stringThreadLocal作为key，"设置value值"作为value保存在threadLocals里。
            stringThreadLocal.set("设置value值");
            System.out.println(Thread.currentThread().getName() + "  " + stringThreadLocal.get());
        }
    }

    class TwoThread extends Thread{

        public TwoThread(){
        }
        @Override
        public void run() {
            //由于没有调用set方法，所以会在第一次调用get()方法中去个给Thread的threadLocals变量赋值
            System.out.println(Thread.currentThread().getName() + "  " + integerThreadLocal.get());
            System.out.println(Thread.currentThread().getName() + "  " + stringThreadLocal.get());
        }
    }
}
