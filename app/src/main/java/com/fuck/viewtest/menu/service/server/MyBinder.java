package com.fuck.viewtest.menu.service.server;

import android.os.Binder;

public class MyBinder extends Binder {
    public void fuckInServer(){
        System.out.println("MyBinder fuckInServer");
    }
}
