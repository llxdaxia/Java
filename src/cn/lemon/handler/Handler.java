package cn.alien95.handler;

/**
 * Created by linlongxin on 2016/4/3.
 */
public class Handler {

    private Looper looper = Looper.getLooper();

    public void sendMessage(Runnable runnable){
        if(looper.getQueue() != null){
            looper.getQueue().add(runnable);
        }

        looper.loop();
    }

    public void handleMessage(Runnable runnable){
        runnable.run();
    }
}
