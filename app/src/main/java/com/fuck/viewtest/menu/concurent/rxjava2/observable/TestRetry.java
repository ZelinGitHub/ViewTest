package com.fuck.viewtest.menu.concurent.rxjava2.observable;

import android.util.Log;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Function;

public class TestRetry {
    private static int i=0;
    public static void testRetryUntil(){


        Observable.create(new ObservableOnSubscribe< Integer >() {
            @Override
            public void subscribe(ObservableEmitter< Integer > e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new Exception("404"));
            }
        })
                .retryUntil(new BooleanSupplier() {
                    @Override
                    public boolean getAsBoolean() throws Exception {
                        return i == 30;
                    }
                })
                .subscribe(new Observer< Integer >() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Integer integer) {
                        i += integer;
                        Log.d("fuck", "onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "onError ");
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }


    public static void testRetryWhen(){
        Observable.create(new ObservableOnSubscribe < String > () {
            @Override
            public void subscribe(ObservableEmitter < String > e) throws Exception {
                e.onNext("A");
                e.onNext("B");
                e.onNext("C");
                e.onNext("D");

                e.onError(new Exception("404"));
                e.onNext("E");
                e.onNext("F");
                e.onNext("G");
            }
        })
                .retryWhen(new Function< Observable < Throwable > , ObservableSource<? >>() {
                    @Override
                    public ObservableSource <? > apply(Observable < Throwable > throwableObservable) throws Exception {
                        return throwableObservable.flatMap(new Function < Throwable, ObservableSource <? >> () {
                            @Override
                            public ObservableSource <? > apply(Throwable throwable) throws Exception {
                                if(throwable.toString().equals("java.lang.Exception: 404")) {
                                    return Observable.just("可以忽略的异常");
                                } else {
                                    return Observable.error(new Throwable("致命错误"));
                                }
                            }
                        });
                    }
                })
                .subscribe(new Observer < String > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("fuck", "==================onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "==================onError " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "==================onComplete ");
                    }
                });

    }
}
