package com.fuck.viewtest.menu.concur;

import android.os.MessageQueue;

public class TestKkoma {
    public static void test(){
        MessageQueue messageQueue;

        MyAsyncTask asyncTask=new MyAsyncTask();
        asyncTask.execute("Faker");
        asyncTask.cancel(true);
    }

}