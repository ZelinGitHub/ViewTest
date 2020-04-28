package com.fuck.viewtest.serv.server;

import android.os.Binder;

public class MyBinder extends Binder {
    public void fuckInServer(){
        System.out.println("fuckInServer");
    }
}
