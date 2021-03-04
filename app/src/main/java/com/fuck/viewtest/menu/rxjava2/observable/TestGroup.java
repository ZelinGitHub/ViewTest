package com.fuck.viewtest.menu.rxjava2.observable;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class TestGroup {

    public static void testGroupBy(){

        Observable.just(5, 2, 3, 4, 1, 6, 8, 9, 7, 10)
                .groupBy(new Function< Integer, Integer >() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer % 3;
                    }
                })
                .subscribe(new Observer<GroupedObservable< Integer, Integer >>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("fuck", "====================onSubscribe ");
                    }

                    //onNext参数是Observable
                    @Override
                    public void onNext(final GroupedObservable < Integer, Integer > integerIntegerGroupedObservable) {


                        Log.d("fuck", "====================onNext ");
                        integerIntegerGroupedObservable.subscribe(new Observer < Integer > () {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.d("fuck", "====================GroupedObservable onSubscribe ");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.d("fuck", "====================GroupedObservable onNext  groupName: " + integerIntegerGroupedObservable.getKey() + " value: " + integer);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("fuck", "====================GroupedObservable onError ");
                            }

                            @Override
                            public void onComplete() {
                                Log.d("fuck", "====================GroupedObservable onComplete ");
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "====================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "====================onComplete ");
                    }
                });

        

    }

    public static void testWindow(){
        Observable.just(1, 2, 3, 4, 5)
                .window(2)
                .subscribe(new Observer < Observable < Integer >> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Observable < Integer > integerObservable) {
                        integerObservable.subscribe(new Observer < Integer > () {
                            @Override
                            public void onSubscribe(Disposable d) {
                            }

                            @Override
                            public void onNext(Integer integer) {
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {
                            }
                        });
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
