package com.fuck.viewtest.menu.concurent.rxjava2.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public class CreatePrepareTest {
    public static void testMoreNext() {

        //创建目标并发送next事件
        //发送的next事件不可以超过10个以上
        //在所有的next事件之后自动发送一个complete事件
        Observable observable = Observable.just(1, 2, 3);
        Observable observable1 = Observable.just(1);
        Integer[] array = {1, 2, 3, 4};
        Observable observable2 = Observable.fromArray(array);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        Observable observable3 = Observable.fromIterable(list);

        Observable observable4 = Observable.range(2, 5);

        Observable observable5 = Observable.rangeLong(2, 5);

        Observable observable6 = Observable.never();
        Observable observable7 = Observable.timer(2, TimeUnit.SECONDS);


        Observable observable8 = Observable.interval(4, TimeUnit.SECONDS);
        Observable observable9 = Observable.intervalRange(2, 5, 2, 1, TimeUnit.SECONDS);

        Observable observable10 = Observable.empty();

        Observable<Integer> observable11 = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(1);
            }
        });
        Observable observable12 = Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "返回结果";
            }
        });

        Observable observable13 = Observable.fromFuture(futureTask);

        ArrayList<Observable<Long>> list2 = new ArrayList<>();
        list2.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS));
        list2.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS));
        Observable observable14 = Observable.amb(list2);


    }


}
