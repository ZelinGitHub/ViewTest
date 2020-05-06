package com.fuck.viewtest.serv.server;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("MyIntentService生命周期：onHandleIntent"+" Intent："+intent.getStringExtra("data"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyIntentService生命周期：onDestroy");
    }
}
