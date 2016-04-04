package cn.alien95.play;

/**
 * Created by linlongxin on 2016/3/2.
 */
public class Play {

    public static void main(String[] args) {
        String a = "123";
        System.out.println(a.hashCode());
        String b = "123";
        System.out.println(a.hashCode());
        Object object = new Object();
        System.out.println(object.hashCode());
        Object object1 = new Object();
        System.out.println(object1.hashCode());
        System.out.println(a == b);
        System.out.println(object == object1);
    }




}
