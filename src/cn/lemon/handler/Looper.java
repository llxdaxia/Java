package cn.alien95.handler;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by linlongxin on 2016/4/3.
 */
public class Looper {

    private static ThreadLocal<Looper> threadLocal = new ThreadLocal<>();
    private LinkedBlockingDeque<Runnable> messageQueue;
    private Handler handler;

    public Looper(){
        messageQueue = new LinkedBlockingDeque<>();
        handler = new Handler();
        threadLocal.set(this);
    }

    public static Looper getLooper(){
        return threadLocal.get();
    }

    public void loop(){
        synchronized (this){
            for (;;){
                handler.handleMessage(messageQueue.poll());
                if(messageQueue.isEmpty()){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

    public LinkedBlockingDeque getQueue(){
        return messageQueue;
    }
}
