package cn.alien95.designmode;

/**
 * Created by linlongxin on 2016/3/20.
 */
public class Singleton {

    //懒汉单例模式
    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
