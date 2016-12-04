package cn.alien95.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by linlongxin on 2016/3/23.
 */
public class Retrofit {

    public static void main(String[] args) {

        Object object = Proxy.newProxyInstance(ServiceAPI.class.getClassLoader(),
                new Class[]{
                    ServiceAPI.class
                }, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if(method.getName().equals("login")){
                            for(Object o : args){
                                System.out.println(o + "---");
                            }
                            return (String)args[0] + (String) args[1];
                        }else if(method.getName().equals("returnSelf")){
                            return proxy;
                        }
                        return null;
                    }
                });
        ServiceAPI serviceAPI = (ServiceAPI) object;
        System.out.println(serviceAPI.login("name","password"));

    }
}
