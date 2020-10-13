package com.fuck.viewtest;

import android.app.Application;
import android.util.Log;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable pThrowable) throws Exception {
                String msg = pThrowable.getMessage();
                if (msg != null) {
                    Log.e("BaseApp", msg);
                }
            }
        });
    }
}
