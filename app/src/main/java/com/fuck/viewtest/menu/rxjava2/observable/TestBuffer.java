package com.fuck.viewtest.menu.rxjava2.observable;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.List;

public class TestBuffer {

    public static void testBuffer(){
        Observable.just(1, 2, 3, 4, 5)
                .buffer(2, 2)
                .subscribe(new Observer< List < Integer >>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List< Integer > integers) {
                        Log.d("fuck", "================缓冲区大小： " + integers.size());
                        for (Integer i: integers) {
                            Log.d("fuck", "================元素： " + i);
                        }
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
