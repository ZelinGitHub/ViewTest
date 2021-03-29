package com.fuck.viewtest.menu.service.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.fuck.viewtest.menu.service.server.MyBinder;

public class Connection1 implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Connection1 onServiceConnected");
        MyBinder myBinder = (MyBinder) service;
        System.out.println("Connection1 获得Binder "+myBinder.hashCode());
        myBinder.fuckInServer();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("Connection1 onServiceDisconnected");
    }
}
