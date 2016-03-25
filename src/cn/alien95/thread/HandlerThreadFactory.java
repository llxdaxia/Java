package cn.alien95.thread;

import java.util.concurrent.ThreadFactory;

/**
 * Created by llxal on 2015/11/25.
 */
public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("thread-id:"+thread.getId());
        return thread;
    }
}
