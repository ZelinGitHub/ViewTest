package com.fuck.viewtest.menu.rxjava2.mergeconcat;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

public class TestMerge {

    public static void testMergeY() {
        Observable<Integer>[] observables = new Observable[]{
                Observable.just(1)
                , Observable.just(2)
                , Observable.just(3)
                , Observable.just(4)
                , Observable.just(5)
                , Observable.just(6)
                , Observable.just(7)
                , Observable.just(8)
        };
        Observable.mergeArray(
                observables
        )
                .subscribe(new Observer<Integer>() {
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
                        Log.d("fuck", "================onComplete");

                    }
                });

    }

    public static void testMerge() {
        Observable.merge(
                Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return "A" + aLong;
                    }
                }),
                Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return "B" + aLong;
                    }
                })
        )
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("fuck", "onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }



    public static void testMergeS() {

        Observable observable1=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onError(new Throwable());

                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);


            }
        });

        Observable observable2=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(999);

                emitter.onNext(888);
                emitter.onNext(777);
                emitter.onNext(666);

                emitter.onNext(555);

            }
        });


        Observable.merge(
                observable1,observable2,Observable.just(6789,4321,1357,9807)
        )
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("fuck", "================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "================onError");

                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "================onComplete");

                    }
                });

    }

    public static void testMergeX() {
        Observable.merge(
                Observable.just(1)
                , Observable.just(2)
                , Observable.just(3)
                , Observable.just(4)
        )
                .subscribe(new Observer<Integer>() {
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
                        Log.d("fuck", "================onComplete");

                    }
                });

    }



}
