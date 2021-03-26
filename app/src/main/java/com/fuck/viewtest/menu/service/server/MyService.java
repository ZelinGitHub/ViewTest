package com.fuck.viewtest.menu.service.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MyService onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyService onStartCommand" + "\nIntent " + intent.getStringExtra("data") + "\nstartId " + startId);
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("MyService onBind");
        return new MyBinder();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        System.out.println("MyService onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("MyService onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyService onDestroy");
    }
}
