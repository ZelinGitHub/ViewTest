package com.fuck.viewtest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("MyBroadcastReceiver收到数据："+intent.getStringExtra("data"));
        System.out.println("MyBroadcastReceiver getResultData："+getResultData());
    }
}
