package com.fuck.viewtest.menu.serv.server;

import android.os.Binder;

public class MyBinder extends Binder {
    public void fuckInServer(){
        System.out.println("MyBinder fuckInServer");
    }
}
