package com.fuck.viewtest.rxjava2.observable;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CreatePrepare {
    public static void testMoreNext() {

        //创建目标并发送next事件
        //发送的next事件不可以超过10个以上
        //在所有的next事件之后自动发送一个complete事件
        Observable observable = Observable.just(1, 2, 3);
        Integer[] array = {1, 2, 3, 4};
        Observable observable2 = Observable.fromArray(array);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        Observable observable3 = Observable.fromIterable(list);

    }

    public static void testFromCallable() {

        Observable observable = Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });

    }
    public static void testFromFuture() {
        FutureTask< String > futureTask = new FutureTask < > (new Callable < String > () {
            @Override
            public String call() throws Exception {
                return "返回结果";
            }
        });

        Observable observable = Observable.fromFuture(futureTask);
    }
}
