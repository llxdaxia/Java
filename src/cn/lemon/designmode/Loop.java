package cn.alien95.designmode;

import java.util.LinkedList;

/**
 * Created by linlongxin on 2016/4/6.
 */
public class Loop{

    private Object object;
    //限制容量为10
    private LinkedList<Runnable> queue = new LinkedList<>();


    class Producer{

        public void add(Runnable runnable){
            synchronized (this){
                if(queue.size() == 10){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    queue.add(runnable);
                    this.notify();
                }
            }
        }

    }


    class Customer{

        public void loop(){

            while (true){
                synchronized (this){

                    if(queue.size() == 0){
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        //处理
                    }
                }
            }

        }
    }
}
