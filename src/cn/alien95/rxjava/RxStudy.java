package cn.alien95.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by linlongxin on 2016/3/16.
 */
public class RxStudy {

    public static void main(String[] args) {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("啦啦啦1");
                subscriber.onNext("啦啦啦2");
                subscriber.onNext("啦啦啦3");
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return null;
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                if(s == "" || s == null){
                    return true;
                }else
                    return false;

            }
        });

        Observable<String> observable1 = Observable.just("啦啦啦1","啦啦啦2","啦啦啦3");
        String[] strings = {"啦啦啦1","啦啦啦2","啦啦啦3"};
        Observable<String> observable2 = Observable.from(strings);
        observable.subscribe(observer);
        observable1.subscribe(observer);
        observable2.subscribe(observer);


        //没有返回值
        Action0 onCompleted = new Action0() {
            @Override
            public void call() {

            }
        };
        //有返回值
        Action1<String> onNext = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        //错误处理
        Action1<Throwable> onError = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        };

        observable.subscribe(onNext,onError,onCompleted);

        Observable.from(new String[]{"123","567"})
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });


    }

}
