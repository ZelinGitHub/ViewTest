package com.fuck.viewtest.menu.concurent.rxjava2.mergeconcat;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;

public class TestConcat {
    public static void getEleFromEmptyList(){
        List<Integer> list=new ArrayList<>();
        System.out.println(list.get(0));
    }

    public static void testConcat() {
        Observable.concat(
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

    public static void testConcatZ() {
        Observable observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(10);
                emitter.onNext(100);
                emitter.onError(new Throwable());
                emitter.onNext(1000);
                emitter.onNext(10000);

            }
        });


        Observable observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(2);
                emitter.onNext(20);
                emitter.onNext(200);
                emitter.onNext(2000);
                emitter.onNext(20000);

            }
        });


        Observable.concat(
                observable1
                ,
                observable2
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

    public static void testConcatG() {
        Observable observable0 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {

                emitter.onComplete();

            }
        });


        Observable observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(10);
                emitter.onNext(100);
                emitter.onNext(1000);
                emitter.onNext(10000);
            }
        });
        Observable observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(2);
                emitter.onNext(20);
                emitter.onNext(200);
                emitter.onNext(2000);
                emitter.onNext(20000);

            }
        });


        Observable.concat(
                observable0
                , observable1
                , observable2
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

    public static void testConcatC() {
        Observable.concat(
                Observable.empty()
                , Observable.empty()
                , Observable.empty()
                , Observable.empty()
        )
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {

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

    public static void testConcatX() {
        Observable<Integer>[] observables = new Observable[]{
                Observable.just(1)
                , Observable.just(2)
                , Observable.just(3)
                , Observable.just(4)
                , Observable.just(5)
                , Observable.just(6)
                , Observable.just(7)
                , Observable.just(8)
                , Observable.just(9)
                , Observable.just(10)
                , Observable.just(11)
                , Observable.just(12)
                , Observable.just(13)
        };
        Observable.concatArray(
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

    public static void testConcatS() {

        Observable observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onComplete();
            }
        });

        Observable observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(999);
                emitter.onComplete();

                emitter.onNext(888);
                emitter.onNext(777);
                emitter.onNext(666);
                emitter.onNext(555);
            }
        });
        Observable.concatArray(
                observable1, observable2
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
