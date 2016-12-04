package cn.alien95.proxy;

/**
 * Created by linlongxin on 2016/3/23.
 */
public interface ServiceAPI {

    String login(String name,String password);
    ServiceAPI returnSelf();
}
