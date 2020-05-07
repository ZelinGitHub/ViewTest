package com.fuck.viewtest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("MyBroadcastReceiver3收到数据："+intent.getStringExtra("data"));
        setResultData("我是MyBroadcastReceiver3");
    }
}
