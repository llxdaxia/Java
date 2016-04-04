package cn.alien95.handler;

/**
 * Created by linlongxin on 2016/4/3.
 */
public class Message implements Runnable {

    private Handler handler = new Handler();
    private Runnable runnable;

    public Message(Runnable runnable){
        this.runnable = runnable;
    }

    @Override
    public void run() {

    }
}
