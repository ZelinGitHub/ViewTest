package com.fuck.viewtest.menu.concurent.rxjava2.mergeconcat;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestMergeError {


    public static void testMergeArrayDelayErrorA() {

        Observable observable1=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onError(new Throwable());
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
                emitter.onError(new Throwable());
                emitter.onNext(666);
                emitter.onNext(555);
            }
        });
        Observable.mergeArrayDelayError(
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
