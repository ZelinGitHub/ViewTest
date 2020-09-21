package com.fuck.viewtest.rxjava2.observable;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TestCollect {
    public static void test(){
        Observable.just(1, 2, 3, 4)
                .collect(
                        new Callable<ArrayList< Integer >>() {
                             @Override
                             public ArrayList < Integer > call() throws Exception {
                                 return new ArrayList < > ();
                             }
                         },
                        new BiConsumer< ArrayList < Integer > , Integer >() {
                            @Override
                            public void accept(ArrayList < Integer > integers, Integer integer) throws Exception {
                                integers.add(integer);
                            }
                        })
                .subscribe(new Consumer< ArrayList < Integer >>() {
                    @Override
                    public void accept(ArrayList < Integer > integers) throws Exception {
                        Log.d("fuck", "accept " + integers);
                    }
                });

    }
}
