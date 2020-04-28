package com.fuck.viewtest.concur;

import android.os.HandlerThread;

public class MyHandlerThread extends HandlerThread {

    public MyHandlerThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
    }
}
