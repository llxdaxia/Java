package cn.alien95.handler;

/**
 * Created by linlongxin on 2016/4/3.
 */
public class Test {

    public static void main(String[] args) {
        Handler handler = new Handler();
        handler.sendMessage(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "  fuck");
            }
        });

    }
}
