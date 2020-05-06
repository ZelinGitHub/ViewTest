package com.fuck.viewtest.serv.client;

import android.os.IBinder;

public class MyDeathRecipient implements IBinder.DeathRecipient {
    @Override
    public void binderDied() {
    }
}
