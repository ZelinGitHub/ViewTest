package com.fuck.viewtest.serv.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.fuck.viewtest.serv.server.MyBinder;

public class MyConnection implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MyBinder myBinder = (MyBinder) service;
        myBinder.fuckInServer();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
