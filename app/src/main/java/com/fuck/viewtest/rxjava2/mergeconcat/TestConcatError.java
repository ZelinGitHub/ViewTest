package com.fuck.viewtest.rxjava2.mergeconcat;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestConcatError {

    public static void testConcatArrayDelayErrorS() {

        Observable observable1=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
                emitter.onNext(4);

            }
        });

        Observable observable2=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(999);
                emitter.onNext(888);
                emitter.onNext(777);
                emitter.onError(new Throwable("999"));
                emitter.onNext(666);
                emitter.onNext(555);

            }
        });
        Observable.concatArrayDelayError(
                observable1,observable2
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
                        Log.d("fuck", "================onError "+e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "================onComplete");

                    }
                });

    }

    public static void testConcatArrayDelayErrorA() {

        Observable observable1=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
            }
        });

        Observable observable2=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(999);
                emitter.onError(new Throwable("999"));
                emitter.onNext(888);
                emitter.onNext(777);
                emitter.onNext(666);
                emitter.onNext(555);

            }
        });
        Observable.concatArrayDelayError(
                observable1,observable2
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
                        Log.d("fuck", "================onError "+e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "================onComplete");

                    }
                });

    }


    public static void testConcatArrayDelayErrorT() {

        Observable observable1=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onError(new Throwable("observable1"));
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
        Observable.concatArrayDelayError(
                observable1,observable2
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
                        Log.d("fuck", "================onError "+e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "================onComplete");

                    }
                });

    }
}
