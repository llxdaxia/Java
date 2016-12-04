package cn.alien95.designmode;

/**
 * Created by linlongxin on 2016/4/2.
 */
public class Singleton2 {

    private Singleton2(){}

    private static class SingletonHolder{
        private static final Singleton2 singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return SingletonHolder.singleton2;
    }
}
