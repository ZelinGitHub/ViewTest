package com.fuck.viewtest.rxjava2.observable;

import android.util.Log;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class TestRepeat {
    public static void testRepeatWhen(){
        Observable.create(new ObservableOnSubscribe< Integer >() {
            @Override
            public void subscribe(ObservableEmitter< Integer > e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
//                e.onComplete();
            }
        })
                .repeatWhen(new Function< Observable < Object > , ObservableSource<? >>() {
                    @Override
                    public ObservableSource <? > apply(Observable < Object > objectObservable) throws Exception {
//                        return Observable.empty();
//                          return Observable.error(new Exception("404"));
                          return Observable.just(4);
                    }
                })
                .subscribe(new Observer< Integer >() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("fuck", "onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "onComplete ");
                    }
                });

    }
}
