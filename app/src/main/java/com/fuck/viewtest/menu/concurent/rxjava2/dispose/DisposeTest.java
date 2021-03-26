package com.fuck.viewtest.menu.concurent.rxjava2.dispose;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

class DisposeTest {
    public static void test() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                //发布事件
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        })
                .subscribe(
                        //观察者
                        new Observer<Integer>() {

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
                        });

    }
}
