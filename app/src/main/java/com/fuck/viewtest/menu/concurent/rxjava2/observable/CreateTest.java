package com.fuck.viewtest.menu.concurent.rxjava2.observable;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CreateTest {
    // i 要定义为成员变量
    private Integer i = 100;

    public static void testCreate() {
        MyObservableOnSubscribe observableOnSubscribe = new MyObservableOnSubscribe();
        Observable<Integer> observable = Observable.create(observableOnSubscribe);
        Observer<Integer> observer = new MyObserver();
        observable.subscribe(observer);

        Observable<Integer> observable1 = observable.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable pDisposable) throws Exception {
                System.out.println();
            }
        });
    }

    static class MyObservableOnSubscribe implements ObservableOnSubscribe<Integer> {
        @Override
        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        }
    }

    static class MyObserver implements Observer<Integer> {
        @Override
        public void onSubscribe(Disposable d) {
        }

        //响应事件
        @Override
        public void onNext(Integer integer) {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onComplete() {
        }
    }

    public static void testCreate2() {
        //目标
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                System.out.println("subscribe 线程" + Thread.currentThread().getName());
                //发布事件
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        })
                .subscribeOn(Schedulers.io())
                //订阅
                .subscribe(
                        //观察者
                        new Observer<Integer>() {

                            @Override
                            public void onSubscribe(Disposable d) {
                                System.out.println("onSubscribe 线程" + Thread.currentThread().getName());
                            }

                            //响应事件
                            @Override
                            public void onNext(Integer integer) {
                                System.out.println("onNext 线程" + Thread.currentThread().getName());
                            }

                            @Override
                            public void onError(Throwable e) {
                                System.out.println("onError 线程" + Thread.currentThread().getName());
                            }

                            @Override
                            public void onComplete() {
                                System.out.println("onComplete 线程" + Thread.currentThread().getName());
                            }
                        });

    }

    public static void testCreateSchedule() {
        System.out.println("testCreateSchedule："
                + Thread.currentThread().getName());
        //目标
        Observer<Integer> observer = new MyObserver();
        ObservableOnSubscribe<Integer> source = new MyObservableOnSubscribe();
        Observable<Integer> integerObservable = Observable.create(source)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        integerObservable.subscribe(observer);

    }


    public void testDelayCreate() {
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);
            }
        });

        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.d("fuck", "================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        i = 200;

        observable.subscribe(observer);

        i = 300;
        // 因为 defer() 只有观察者订阅的时候才会创建新的被观察者，
        // 所以每订阅一次就会打印一次，并且都是打印 i 最新的值。
        observable.subscribe(observer);
    }

    public static void ambTest() {
        ArrayList<Observable<Long>> list = new ArrayList<>();
        list.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS));
        list.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS));

        Observable.amb(list)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("amb", "========================aLong " + aLong);
                    }
                });

    }

}
