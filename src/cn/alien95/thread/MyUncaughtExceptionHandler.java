package cn.alien95.thread;

/**
 * Created by llxal on 2015/11/25.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getId());
        System.out.println(e.getMessage());
    }
}
