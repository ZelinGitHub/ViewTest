package com.fuck.viewtest.menu.rxjava2.observable;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class ScanReduceTest {
    public static void testScan(){
        Observable.just(1, 2, 3, 4, 5)
                .scan(new BiFunction< Integer, Integer, Integer >() {
                    @Override
                    public Integer apply(Integer integerFirst, Integer integerSecond) throws Exception {
                        Log.d("fuck", "---------------------------------------------------------------");
                        Log.d("fuck", "First " + integerFirst);
                        Log.d("fuck", "Second " + integerSecond);
                        Log.d("fuck", "---------------------------------------------------------------");
                        return integerFirst + integerSecond;
                    }
                })
                .subscribe(new Consumer< Integer >() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("fuck", "---------------------------------------------------------------");
                        Log.d("fuck", "accept " + integer);
                        Log.d("fuck", "---------------------------------------------------------------");
                    }
                });
    }

    public static void testReduce(){
        Observable.just(1, 2, 3,4,5)
                .reduce(new BiFunction < Integer, Integer, Integer > () {
                    @Override
                    public Integer apply(Integer tA, Integer tB) throws Exception {
                        int apply = tA + tB;
                        Log.d("fuck", "tA " + tA);
                        Log.d("fuck", "tB " + tB);
                        Log.d("fuck", "apply " + apply);
                        return apply;
                    }
                })
                .subscribe(new Consumer < Integer > () {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("fuck", "accept " + integer);
                    }
                });

      
    }
}
