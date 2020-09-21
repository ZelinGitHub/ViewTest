package com.fuck.viewtest.rxjava2.combine;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

public class Zip {
    public static void testZip() {

        Observable observableA =    //observable
                Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)
                        //变换long为string
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                String a = "A" + aLong;
                                Log.d("fuck", "A发送 " + a);
                                return a;
                            }
                        });

        Observable observableB = Observable.intervalRange(1, 6, 1, 1, TimeUnit.SECONDS)
                //变换long为string
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        String b = "B" + aLong;
                        Log.d("fuck", "B发送 " + b);
                        return b;
                    }
                });

        BiFunction biFunction = new BiFunction<String, String, String>() {
            @Override
            public String apply(String x, String y) throws Exception {
                return x + y;
            }
        };

        Observable.zip(
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
                        Log.d("fuck", "onNext " + s);
                        Log.d("fuck", "----------------------------------");
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
