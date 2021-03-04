package com.fuck.viewtest.menu.concur;

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
