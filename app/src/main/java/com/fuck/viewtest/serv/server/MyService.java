package com.fuck.viewtest.serv.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MyService生命周期 onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyService生命周期 onStartCommand" + "\nIntent " + intent.getStringExtra("data") + "\nstartId " + startId);
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("MyService生命周期 onBind");
        return new MyBinder();
    }


    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("MyService生命周期 onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyService生命周期 onDestroy");
    }
}
