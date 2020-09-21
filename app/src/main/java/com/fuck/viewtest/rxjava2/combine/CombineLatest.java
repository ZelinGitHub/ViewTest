package com.fuck.viewtest.rxjava2.combine;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

public class CombineLatest {
    public static void testCombineLatest() {
        Observable<String> observableA = Observable.intervalRange(1, 4, 1, 1, TimeUnit.SECONDS)
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        String s1 = "A" + aLong;
                        Log.d("fuck", "A发送 " + s1);
                        return s1;
                    }
                });
        Observable<String> observableB = Observable.intervalRange(1, 5, 2, 2, TimeUnit.SECONDS)
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        String s2 = "B" + aLong;
                        Log.d("fuck", "B发送 " + s2);
                        return s2;
                    }
                });
        BiFunction<String, String, String> biFunction = new BiFunction<String, String, String>() {
            @Override
            public String apply(String sA, String sB) throws Exception {
                return sA + sB;
            }
        };
        Observable.combineLatest(
                observableA,
                observableB,
                biFunction
                )
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("fuck", "最终接收到 " + s);
                        Log.d("fuck", "--------------------------------");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }
}
