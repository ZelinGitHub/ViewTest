package com.fuck.viewtest.menu.serv.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.fuck.viewtest.menu.serv.server.MyBinder;

public class Connection2 implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Connection2 onServiceConnected");
        MyBinder myBinder = (MyBinder) service;
        System.out.println("Connection2 获得Binder " + myBinder.hashCode());
        myBinder.fuckInServer();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("Connection2 onServiceDisconnected");
    }
}
