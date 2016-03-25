package cn.alien95.designmode;

/**
 * Created by linlongxin on 2016/3/20.
 */
public class Singleton1 {

    //饿汉单例模式
    private static Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }
}
